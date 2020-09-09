package com.fpinjava.makingjavafunctional.exercise03_11;

import static com.fpinjava.makingjavafunctional.exercise03_08.CollectionUtilities.append;
import static com.fpinjava.makingjavafunctional.exercise03_08.CollectionUtilities.foldLeft;

import java.util.ArrayList;
import java.util.List;


public class Range {

//  public static List<Integer> range(int start, int end) {
//    List<Integer> list = new ArrayList<>();
//    for(int i=start; i< end; i++) {
//      list.add(i);
//    }
//    return list;
//  }
//
//}

  public static List<Integer> range(int start, int end) {
    List<Integer> list = new ArrayList<>();
    for (int i = start; i < end; i++) {
//      list = append(list, i);
       list = append(list, foldLeft(list, i, x -> y -> x+1));

    }
    return list;
  }
}