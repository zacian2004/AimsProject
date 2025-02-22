package AimsProject;

import java.util.Comparator;

public abstract class Media{
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    
    private static int nbMedia = 0;
    private int id;
    private String title;
    private String category;
    private float cost;

    public int getID(){
        return this.id;
    }

    public void setID(int i){
        this.id = i;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String s){
        this.title = s;
    }

    public String getCategory(){
        return this.category;
    }

    public void setCategory(String s){
        this.category = s;
    }

    public float getCost(){
        return this.cost;
    }

    public void setCost(float f){
        this.cost = f;
    }

    public Media(String title, String category, float cost){
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
        nbMedia++;
        this.setID(nbMedia);
    } 

    public Media(String title) {
        this.setTitle(title);
    }   
    public void printToString() {
        System.out.println(getID() + " "
                            + getTitle() + " - "
                            + getCategory() + ": "
                            + getCost() + " $\n");
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)   
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Media m = (Media) obj;
        return getTitle().equals(m.getTitle());
    }
}