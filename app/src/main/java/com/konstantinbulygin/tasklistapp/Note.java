package com.konstantinbulygin.tasklistapp;

public class Note {

    private int id;
    private String title;
    private String description;
    private int dayOfWeek;
    private int priority;

    public Note(int id, String title, String description, int dayOfWeek, int priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dayOfWeek = dayOfWeek;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public String getDescription() {
        return description;
    }


    public int getDayOfWeek() {
        return dayOfWeek;
    }


    public int getPriority() {
        return priority;
    }

    public static String getDayString(int dayOfWeek) {

        switch (dayOfWeek) {
            case 0:
                return "Monday";
            case 1:
                return "Tuesday";
            case 2:
                return "Wednesday";
            case 3:
                return "Thursday";
            case 4:
                return "Friday";
            case 5:
                return "Saturday";
             default:
                 return "Sunday";
        }
    }

}
