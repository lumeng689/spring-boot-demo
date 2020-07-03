package org.luapp.tpl.utils;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.io.IOUtil;
import com.hankcs.hanlp.dictionary.CoreDictionary;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author: 86150
 * @create: 2020/05/11
 **/
public class HanlpTest {
    public static void main(String[] args) throws Exception {
        HanLP.Config.enableDebug();
        System.out.println(HanLP.segment("你好，欢迎使用HanLP汉语处理包"));

        TreeMap<String, CoreDictionary.Attribute> dictionary = IOUtil.loadDictionary("c:/api-projects/HanLP/data/dictionary/CoreNatureDictionary.mini.txt");
        System.out.printf("词典大小 : %d个词条\n", dictionary.size());
        System.out.println(segmentFully("就读北京大学", dictionary));
    }

    public static List<String> segmentFully(String text, TreeMap<String, CoreDictionary.Attribute> dictionary) {
        List<String> wordList = new LinkedList<>();

        for (int i = 0; i < text.length(); i++) {
            for (int j = i + 1; j <= text.length(); j++) {
                String word = text.substring(i, j);
                if (dictionary.containsKey(word)) {
                    wordList.add(word);
                }
            }
        }
        return wordList;
    }
}
