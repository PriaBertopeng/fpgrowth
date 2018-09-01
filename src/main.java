
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LENOVO
 */
public class main {

    public static void main(String[] args) {

//        Fpgrowth data[] = new Fpgrowth[10];
//        data[0] = new Fpgrowth("bersih bagus aakm");
//        data[1] = new Fpgrowth("bersih rapi aakm");
//        data[2] = new Fpgrowth("rapi bagus aakm");
//        data[3] = new Fpgrowth("bagus rapi aakm");
//        data[4] = new Fpgrowth("bagus rapi aakm");
//        data[5] = new Fpgrowth("bagus sejuk aakm");
//        data[6] = new Fpgrowth("bersih sejuk bagus aakm");
//        data[7] = new Fpgrowth("bagus aakm");
//        data[8] = new Fpgrowth("mudah aakm");
//        data[9] = new Fpgrowth("bagus aakm");
//        System.out.println("tes");
//ArrayList al = new ArrayList();
        ArrayList<String> obj = new ArrayList<String>();
        obj.add("bersih bagus aakm");
        obj.add("bersih rapi aakm");
        obj.add("rapi bagus aakm");
        obj.add("bagus rapi aakm");
        obj.add("bagus rapi aakm");
        obj.add("bagus sejuk aakm");
        obj.add("bersih sejuk bagus aakm");
        obj.add("bagus aakm");
        obj.add("mudah aakm");
        obj.add("bagus aakm");

        String[] arr;
        ArrayList<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>>();

        for (int i = 0; i < obj.size(); i++) {
            arr = obj.get(i).split(" ");
            ArrayList<String> tmp = new ArrayList<String>();

            for (int j = 0; j < arr.length; j++) {
                tmp.add(arr[j]);
            }

            listOfLists.add(tmp);

        }
        System.out.println(listOfLists);

//------------------------------------------------------------------------------------------------
        ArrayList<String> frq = new ArrayList<String>();
        ArrayList<Integer> cnt = new ArrayList<Integer>();
//        System.out.println("size: "+listOfLists.get(0).size());
        for (int i = 0; i < listOfLists.size(); i++) {
            for (int j = 0; j < listOfLists.get(i).size(); j++) {
                if (frq.size() == 0) {
                    frq.add(listOfLists.get(i).get(j));
                    cnt.add(1);
                } else {
                    boolean podo = false;
                    for (int k = 0; k < frq.size(); k++) {
                        if (frq.get(k).equals(listOfLists.get(i).get(j))) {
                            //count+1
//                            cnt.set(k, 9);
                            cnt.set(k, cnt.get(k) + 1);
                            podo = true;
                            break;
                        }
                    }
                    if (podo == false) {
                        frq.add(listOfLists.get(i).get(j));
                        cnt.add(1);
                    }
                }
            }
        }
        System.out.println(frq);
        System.out.println(cnt);
//------------------------------------------------------------------------------------------------

        for (int i = 0; i < cnt.size() - 1; i++) {
            int t = 0;
            int index = 0;
            for (int j = i; j < cnt.size(); j++) {
                if (cnt.get(j) >= t) {
                    t = cnt.get(j);
                    index = j;
                }
            }
            //swap
            int x = cnt.get(i);
            cnt.set(i, t);
            cnt.set(index, x);
            //swap string
            String y = frq.get(i);
            frq.set(i, frq.get(index));
            frq.set(index, y);

        }

        System.out.println(cnt);
        System.out.println(frq);

//------------------------------------------------------------------------------------------------
        int minsupp = 2;
        for (int i = 0; i < cnt.size(); i++) {
            if (cnt.get(i) < minsupp) {
                String a = frq.get(i);
                cnt.remove(i);
                frq.remove(i);
                for (int j = 0; j < listOfLists.size(); j++) {
                    for (int k = 0; k < listOfLists.get(j).size(); k++) {
                        if (listOfLists.get(j).get(k).equalsIgnoreCase(a)) {
                            listOfLists.get(j).remove(k);

                        }
                    }
                }

            }
        }
        System.out.println(cnt);
        System.out.println(frq);

//------------------------------------------------------------------------------------------------
        System.out.println(listOfLists);
        System.out.println("");
//                    System.out.println(listOfLists.get(6));

        for (int h = 0; h < listOfLists.size(); h++) {
            for (int i = 0; i < listOfLists.get(h).size() - 1; i++) {
                int indexcount = 0;
                int count = 0;
                int index = 0;
                String a = null;
                for (int j = i; j < listOfLists.get(h).size(); j++) {
//                System.out.println(listOfLists.get(0).get(j));
                    for (int k = 0; k < frq.size(); k++) {
//                    System.out.println(k);
                        if (listOfLists.get(h).get(j).equalsIgnoreCase(frq.get(k))) {
//                        System.out.println(listOfLists.get(0).get(j));
                            indexcount = k;
                            break;
                        }
                    }
                    if (cnt.get(indexcount) >= count) {
                        count = cnt.get(indexcount);
                        index = j;
                        a = frq.get(indexcount);

//                    System.out.println(frq.get(indexcount));
                    }
                }
//                System.out.println("");
                String x = listOfLists.get(h).get(i);
//            System.out.println("string x= " + x);
//            System.out.println("index count= " + index);
//                System.out.println(frq.get(indexcount));
                listOfLists.get(h).set(i, a);
//            System.out.println(listOfLists.get(6));

                listOfLists.get(h).set(index, x);
//            System.out.println(listOfLists.get(6));

            }
        }
//                    System.out.println(listOfLists.get(6));

        System.out.println(listOfLists);

        //------------------------------------------------------------------------------------------------
        ArrayList<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();

//aakm=1
//baggis=2
//rapi=3
//bersih=4
//sejuk=5
//mudah=6
        for (int i = 0; i < listOfLists.size(); i++) {
            ArrayList<Integer> trans = new ArrayList<Integer>();

            for (int j = 0; j < listOfLists.get(i).size(); j++) {
                switch (listOfLists.get(i).get(j)) {
                    case "aakm":
                        trans.add(1);
                        break;
                    case "bagus":
                        trans.add(2);
                        break;
                    case "rapi":
                        trans.add(3);
                        break;
                    case "bersih":
                        trans.add(4);
                        break;
                    case "sejuk":
                        trans.add(5);
                        break;
                    case "mudah":
                        trans.add(6);
                        break;
                }
            }
            tree.add(i, trans);

        }
        System.out.println(tree);

        //
        
//        ----------------------------------------------------------------------------------------------
Graph coba =new Graph(5);
//coba.addAdj(0, 1);
//coba.cetak();
for (int i = 0; i < tree.size(); i++) {
            coba.addAdj(tree.get(i));
        }

//coba.addAdj(tree.get(0));
//coba.cetak();
//coba.addAdj(tree.get(1));
//coba.cetak();
//coba.addAdj(tree.get(2));
coba.cetak();


//--------------------------------------------------------------------------------------------------------------


//coba.tes();
    }

}
