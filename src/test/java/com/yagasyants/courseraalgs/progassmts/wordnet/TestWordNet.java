package com.yagasyants.courseraalgs.progassmts.wordnet;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestWordNet {
	private static final String FILE_DIR = "wordnet";
	private static final String SYN_1 = "synsets_1.txt";
	private static final String HYP_1 = "hypernyms_1.txt";
	private static final String REAL_SYN = "real_synsets.txt";
	private static final String REAL_HYP = "real_hypernyms.txt";
	
	@Test
	public void testLoadFile(){
		String synFileStr = getFullFileName(SYN_1);
		
		File file = new File(synFileStr);
		
		assertTrue(file.exists());
		assertEquals(SYN_1, file.getName());
	}
	
	@Test
	public void testInitAndNouns(){
		WordNet wordNet = new WordNet(getSyn1(), getHyp1());
		
		Iterable<String> nouns = wordNet.nouns();
		List<String> listStr = toList(nouns);
		
		assertTrue(listStr.contains("event"));
	}
	
	@Test
	public void testIsNoun(){
		WordNet wordNet = new WordNet(getSyn1(), getHyp1());
		
		assertTrue(wordNet.isNoun("event"));
		assertFalse(wordNet.isNoun("fhdshkjfdl"));
	}
	
	private List<String> toList(Iterable<String> iterable){
		List<String> list = new ArrayList<>();
		for(String str : iterable){
			list.add(str);
		}
		return list;
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testVerifyNoCycles(){
		new WordNet(getSyn1(), getFullFileName("cycle_hyp_1.txt"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testVerifyRooted(){
		new WordNet(getSyn1(), getFullFileName("not_root_dag_hyp_1.txt"));
	}
	
	@Test
	public void testVerifyRealFiles(){
		WordNet wordNet = new WordNet(getRealSyn(), getRealHyp());
		
		Iterable<String> nouns = wordNet.nouns();
		List<String> listStr = toList(nouns);
		
		assertTrue(listStr.contains("Alcea"));
	}
	


	private String getSyn1(){
		return getFullFileName(SYN_1);
	}
	
	private String getHyp1(){
		return getFullFileName(HYP_1);
	}
	
	private String getRealSyn(){
		return getFullFileName(REAL_SYN);
	}
	
	private String getRealHyp(){
		return getFullFileName(REAL_HYP);
	}
	
	private String getFullFileName(String name){
		String fullFileName = FILE_DIR + File.separator + name;
		return getClass().getClassLoader().getResource(fullFileName).getFile();
	}

}
