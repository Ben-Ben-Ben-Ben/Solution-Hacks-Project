import java.util.ArrayList;
import java.util.Random;

public class GarbageItem {

    private static ArrayList<GarbageItem> trashList = new ArrayList<>();
    public String Name;
    public String Type;
    public String Image;
    public String GameOverTip;

    public GarbageItem(String name, String type, String imagePath, String tip) {
        this.Name = name;
        this.Type = type;
        this.Image = "Illustrations/" + imagePath;
        this.GameOverTip = tip;

        trashList.add(this);
    }

    public static GarbageItem getRandom() {
        int rand = new Random().nextInt(trashList.size());
        return trashList.get(rand);
    }
}