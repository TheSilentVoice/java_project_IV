import java.io.*;
import java.util.Scanner;

public class save_controller {

    static boolean new_game;
    static File save_file = new File("save.txt");
    static BufferedWriter wr;

    static {
        try {
            wr = new BufferedWriter(new FileWriter("save.txt",false));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static BufferedReader k;

    static {
        try {
            k = new BufferedReader(new FileReader("save.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public save_controller() throws IOException {
    }

    public static void save_game() throws IOException {

            wr.write(String.valueOf(resources.mana_value)+"\n");
            wr.write(String.valueOf(resources.wood_value)+"\n");
            wr.write(String.valueOf(resources.food_value)+"\n");
            wr.write(String.valueOf(resources.pop_value)+"\n");
            wr.write(String.valueOf(resources.church_level)+"\n");
            wr.write(String.valueOf(resources.wood_cabins)+"\n");
            wr.write(String.valueOf(resources.farms)+"\n");
            wr.write(String.valueOf(resources.hall_level)+"\n");
            wr.write(String.valueOf(resources.wood_cap)+"\n");
            wr.write(String.valueOf(resources.food_cap)+"\n");
            wr.write(String.valueOf(resources.pop_cap)+"\n");
            wr.write(String.valueOf(resources.cabin_cost)+"\n");
            wr.write(String.valueOf(resources.church_cost)+"\n");
            wr.write(String.valueOf(resources.deposit_cost)+"\n");
            wr.write(String.valueOf(resources.farm_cost)+"\n");
            wr.write(String.valueOf(resources.stock_cost)+"\n");

            wr.close();

    }

    public static void load_game() throws IOException {

        resources.mana_value= Double.parseDouble(k.readLine());
        resources.wood_value= Double.parseDouble(k.readLine());
        resources.food_value= Double.parseDouble(k.readLine());
        resources.pop_value= Double.parseDouble(k.readLine());
        resources.church_level= Double.parseDouble(k.readLine());
        resources.wood_cabins= Double.parseDouble(k.readLine());
        resources.farms= Double.parseDouble(k.readLine());
        resources.hall_level= Double.parseDouble(k.readLine());
        resources.wood_cap= Double.parseDouble(k.readLine());
        resources.food_cap= Double.parseDouble(k.readLine());
        resources.pop_cap= Double.parseDouble(k.readLine());
        resources.cabin_cost= Double.parseDouble(k.readLine());
        resources.church_cost= Double.parseDouble(k.readLine());
        resources.deposit_cost= Double.parseDouble(k.readLine());
        resources.farm_cost= Double.parseDouble(k.readLine());
        resources.stock_cost= Double.parseDouble(k.readLine());

        k.close();

    }



}
