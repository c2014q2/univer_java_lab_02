import java.util.Random;

public abstract class Om {
    protected byte statut_social;
    protected int height;
    protected float weight;
    protected String eyes_color;
    protected boolean is_man;

    protected final static String[] eyes_colors = new String[]{"Brown", "Blue", "Green", "Red", "Yellow", "Black", "White", "Pink", "Purple"};
    protected final static String[] drepturi = new String[]{"Om", "User", "Admin", "Boss"};


    public Om() {
        Random rand = new Random();
        statut_social = 0;
        height = rand.nextInt(215)+50;
        weight = rand.nextFloat(200)+50;
        eyes_color = eyes_colors[rand.nextInt(eyes_colors.length)];
        is_man = rand.nextBoolean();
    }

    public Om(int height, float weight, String eyes_color, boolean is_man) {

        if (height >= 90) {
            this.height = height;
        }
        if (weight >= 5) {

            this.weight = weight;
        }
        this.eyes_color = eyes_color;
        this.is_man = is_man;
    }

    public void printDetails(){
        System.out.println("Height: " + height+" cm");
        System.out.println("Weight: " + weight+" kg");
        System.out.println("Eyes color: " + eyes_color);
        System.out.println("Is man: " + is_man);

    }

    //public abstract void saveObjectToFile(String nameFile);





    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height >= 50) {
            this.height = height;
        }
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        if (weight <= 30) {
            this.weight = weight;
        }
    }

    public boolean isIs_man() {
        return is_man;
    }

    public void setIs_man(boolean is_man) {
        this.is_man = is_man;
    }

    public String getEyes_color() {
        return eyes_color;
    }

    public void setEyes_color(String eyes_color) {
        this.eyes_color = eyes_color;
    }
}


