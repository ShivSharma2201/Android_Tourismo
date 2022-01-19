package com.example.group_project_android;

import java.util.ArrayList;

public class ActivitiesDB {

    private static ActivitiesDB instance = null;

    public static ActivitiesDB getInstance() {
        if (instance == null) {
            instance = new ActivitiesDB();
        }
        return instance;
    }
    private ActivitiesDB(){
        this.activityList = new ArrayList<ActivityDetails>();
        this.userList = new ArrayList<UserDetails>();
        activityList.add(new ActivityDetails(1,"AMUSEMENT PARK","With more than 30 rides and attractions and 14 mouth-watering food outlets, Centre Island’s iconic Centreville Amusement Park is the ultimate summer destination for families with young children!",4,"Alpha Tours",50,"https://fthmb.tqn.com/RcLUz85RoXg0TKcUL7slyvhLoQg=/960x0/filters:no_upscale()/adventureland-5aafd0ec8023b90036bef773.jpg",14844458));
        activityList.add(new ActivityDetails(2,"MUSEUM","explore the history, art and culture of Toronto at The Museum of Contemporary Art.",3,"Beta Tours",10,"https://media.timeout.com/images/100014729/image.jpg",12212448));
        activityList.add(new ActivityDetails(3,"BEACH","Also known as “The Beaches,” this relaxed neighbourhood with a small-town vibe is a top summer destination, drawing families and tourists to its sandy beaches and quaint boardwalk. ",5,"Gamma Tours",5,"https://images.unsplash.com/photo-1620127682229-33388276e540?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8c3VtbWVyJTIwYmVhY2h8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80",12211445));
        activityList.add(new ActivityDetails(4,"ICE SKATING","The sound of blades gliding on ice, the crisp winter air and a mug of steaming hot chocolate warming your hands." ,5,"Theta Tours",40,"https://storage.googleapis.com/proudcity/ketteringohparks/uploads/2019/08/KetteringIceClinic-60.jpg",12211445));
        activityList.add(new ActivityDetails(5,"NATURE WALK","Looking for a great trail near Toronto, Ontario? BELTLINE TRAIL has THE great trail running trails, hiking trails, mountain biking trails and more, with hand-curated trail maps and driving directions as well as detailed reviews and photos from hikers, campers, and nature lovers like you.",2,"Greek Tours",5,"https://images.fineartamerica.com/images-medium-large-5/fall-nature-walk-kimberly-davidson.jpg",12211445));

        userList.add(new UserDetails("Stavan","stavan@gmail.com","stavan@123",0));
        userList.add(new UserDetails("Shivam","shivam@gmail.com","shivam@123",1));
        userList.add(new UserDetails("Nikhil","nikhil@gmail.com","nikhil@123",2));


    }



    private ArrayList<UserDetails> userList;
    private ArrayList<ActivityDetails> activityList;
    private ArrayList<UserAct> favlist= new ArrayList<>();
    private ArrayList<UserAct> booklist= new ArrayList<>();

    public ArrayList<UserAct> getFavlist() {
        return favlist;
    }

//
    public ArrayList<UserAct> getBooklist() { return booklist; }

    public ArrayList<ActivityDetails> getActivityList(){
        return this.activityList;
    }

    public ArrayList<UserDetails> getUserList(){
        return this.userList;
    }
}
