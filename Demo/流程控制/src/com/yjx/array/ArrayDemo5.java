package com.yjx.array;

public class ArrayDemo5 {
    public static void main(String[] args) {
        int[][] array={{1,2},{1,2},{1,3},{4,5}};
//        System.out.println(array[3][1]);
//        for(int i=0;i<array.length;i++){
//            for(int j=0;j<array[i].length;j++){
//                System.out.print(array[i][j]+"\t");
//            }
//        }
        arrays(array);
        name("sss");
    }
    public static int[][] arrays(int[][] array){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                System.out.print(array[i][j]+"\t");
            }
        }
        return array;
   }
   public static  void name(String name){
       System.out.println(name);
       return ;
   }
}
