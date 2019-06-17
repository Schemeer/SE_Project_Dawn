import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.beans.IntrospectionException;
import java.util.Vector;
import java.util.Random;



public class MapClass {

    Random rand=new Random();
    static int unit =150;
    static int size =20;
    private static int border = 2;
    private int sizeOfProp = 20;

    public Vector<Prop> proplist;
    private Prop prop_sample;
   // public Vector<> rankrecord;
    public int[][] m;

    public MapClass () {

        proplist = new Vector<Prop>();
     //   rankrecord = new Vector<Role>();

//        String st="1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111\n" +
//                "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111\n" +
//                "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111\n" +
//                "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111\n" +
//                "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111\n" +
//                "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000000111111111111111111111111111111111111111100000000000000000011111000000000000000111111\n" +
//                "1111110000000000111111111111111111111111111111111111111100000000000000000011111000000000000000111111\n" +
//                "1111110000000000111111111111111111111111111111111111111100000000000000000011111000000000000000111111\n" +
//                "1111110000000000111111111111111111111111111111111111111100000000000000000011111000000000000000111111\n" +
//                "1111110000000000111111111111111111111111111111111111111100000000000000000011111000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000011111000000000000000111111\n" +
//                "1111110000000001111100000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000001111100000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000001111100000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000001111100000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000001111100000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000001111100000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000001111100000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000001111100000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000001111100000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000001111100000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000001111100000000001111111111111111111111111111111111111111000000000000000000000000111111\n" +
//                "1111110000000001111100000000001111111111111111111111111111111111111111000000000000000000000000111111\n" +
//                "1111110000000001111100000000001111111111111111111111111111111111111111000000000000000000000000111111\n" +
//                "1111110000000001111100000000001111111111111111111111111111111111111111000000000000000000000000111111\n" +
//                "1111110000000001111100000000001111111111111111111111111111111111111111000000000000000000000000111111\n" +
//                "1111110000000001111100000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000001111100000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000001111100000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000001111100000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000001111100000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000111111111111111111111111111111111111111111111111110000000000000000000111111\n" +
//                "1111110000000000000000000111111111111111111111111111111111111111111111111110000000000000000000111111\n" +
//                "1111110000000000000000000111111111111111111111111111111111111111111111111110000000000000000000111111\n" +
//                "1111110000000000000000000111111111111111111111111111111111111111111111111110000000000000000000111111\n" +
//                "1111110000000000000000000111111111111111111111111111111111111111111111111110000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111\n" +
//                "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111\n" +
//                "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111\n" +
//                "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111\n" +
//                "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111\n" +
//                "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111\n" +
//                "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111\n";
        String st = "11111111111111111111\n" +
                "11111111111111111111\n" +
                "11000000000000000011\n" +
                "11000000000000000011\n" +
                "11000000000000000011\n" +
                "11000000000000000011\n" +
                "11000000000000000011\n" +
                "11000000000000000011\n" +
                "11000000000000000011\n" +
                "11000000000000000011\n" +
                "11000000000000000011\n" +
                "11000000000000000011\n" +
                "11000000000000000011\n" +
                "11000000000000000011\n" +
                "11000000000000000011\n" +
                "11000000000000000011\n" +
                "11000000000000000011\n" +
                "11000000000000000011\n" +
                "11111111111111111111\n" +
                "11111111111111111111\n";
        m=new int[size][size];
        int row=0; int col=0;
        for (int i=0;i<st.length();i++) {
            char[] chr=st.toCharArray();
            switch (chr[i]){
                case '1':m[col][row]=1; row++; break;
                case '0':m[col][row]=0; row++; break;
                case  '\n' : row=0;col++;
            }
        }
        int proptype;
        int[] proposition = new int[2];
        int x,y;
        for (int i = 0; i <sizeOfProp; i++) { //构造prop的，测试生成30个
            proptype = i % 4;
            prop_sample = new Prop(i,proptype);
            do {
                x = rand.nextInt(unit * (size - 2 * border)) + unit * border;
                y = rand.nextInt(unit * (size - 2 * border)) + unit * border;
            }while(!is_valid(x,y));
            proposition[0] = x;
            proposition[1] = y;
            prop_sample.setPropposition(proposition);
            proplist.add(i, prop_sample);
        }

    }


    private boolean is_valid(int x,int y){
        return (m[y/unit][x/unit]==0);
    }


    Vector<Integer> getPropList() {
        Vector<Integer> tmp = new Vector<>();
        int count = 0;
        for (Prop prop: proplist){
            tmp.addAll(prop.getPropPara());
            count += 1;
        }
        return tmp;
    }

    int[] getPropStatus() {
        int [] tmp = new int[20];
        for (int i = 0; i < proplist.size(); i++){
            if(proplist.get(i).isPickable()) tmp[i] = 1;
            else tmp[i] = 0;
        }
        return tmp;
    }
}
