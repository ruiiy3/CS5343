import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

public class Hash {
    private static final int Ascii = 53;
    int element;
    int collision;
    String[] table;
    double load;
    public Hash(int size) {
        this.table = new String[size];
        for(int i = 0; i < size; i++)
            table[i] = null;
        collision = 0;
        element = 0;
    }
    public int hashValue(String word, int n) throws UnsupportedEncodingException {
        //long value = 0;
        int value = 0;
        byte[] bytes = word.getBytes("US-ASCII");
        for(int i = 0; i < bytes.length; i++) {

            value = Ascii * value + bytes[i];
        }
        //System.out.println(value);
        value = (value + n  * n) % table.length;

        if(value < 0)
            value += table.length;
        //System.out.println(value);
        return (int)value;

    }
    public void insert(String v) throws UnsupportedEncodingException {
        int i = 0;
        int index;
        while(true) {
            index = hashValue(v, i);
            if(table[index] == null) {
                table[index] = v;
                element++;
                break;
            }
            else{
                if(table[index].equals(v))
                    break;
            }
            i++;
        }
        collision += i;
    }
    public void check_factor(String v) throws UnsupportedEncodingException {
        load = (double) (element + 1) / (double) table.length;
        if(load < 0.5)
            insert(v);
        else {
            increaseSize(v);
        }
    }
    public void increaseSize(String val) throws UnsupportedEncodingException {
        //System.out.println("Factor large or equal to 0.5, increasing table size.");
        String[] tmp = this.table;
        int s = nextPrime(table.length * 2);
        table = new String[s];
        load = 0;
        element = 0;
        for(int i = 0; i < tmp.length; i++) {
            if(tmp[i] != null)
                insert(tmp[i]);
        }
        insert(val);
    }
    public static boolean isPrime(int size) {
        int i = 2;
        while(i <= size /2) {
            if(size % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }
    public static int nextPrime(int size) {
        if(isPrime(size))
            return size;
        else
            return nextPrime(size + 1);
    }

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        String[] s = new String[20];
        Scanner scanner = new Scanner(new File("word.txt"));
        int i = 0;
        while(scanner.hasNextLine()) {
            s[i] = scanner.nextLine();
            i++;
        }
        //for(int j = 0; j < 20; j++)
            //System.out.println(s[j]);

        Hash quadHash = new Hash(31);
        for(int t = 0; t < 20; t++) {
            quadHash.check_factor(s[t]);
        }

        System.out.println("Total Collisions: " + quadHash.collision);
        System.out.println("Final table size: " + quadHash.table.length);
        System.out.println("Final table is:\n " + Arrays.toString(quadHash.table));
    }


}
