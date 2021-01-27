package com.maruf.banglaquran;

import java.io.Serializable;

public class DataModel implements Serializable {
    private String SurahName, Chapter, Verse, arabic, bangla;
    private String SurahId,sid;
    //Constructors
    public DataModel(){

    }
    public DataModel(String Sname, String chapterNo, String verseNo) {
        this.SurahName = Sname;
        this.Chapter = chapterNo;
        this.Verse = verseNo;
    }
    public String getId(){
        return sid;
    }
    public void setId(String sidd){
        this.sid=sidd;
    }
    public String getSurahName() {
        return SurahName;
    }
    public void setSurahName(String surah) {
        this.SurahName = surah;
    }
    public String getChapter() {
        return Chapter;
    }
    public void setChapter(String chNo) {
        this.Chapter = chNo;
    }
    public String getVerse(){
        return Verse;
    }
    public void setVerse(String vrsNo){
        this.Verse = vrsNo;
    }

    //Set & Get Ayats
    public String getSurahId() {
        return SurahId;
    }
    public void setSurahId(String surah) {
        this.SurahId = surah;
    }
    public String getArabic() {
        return arabic;
    }
    public void setArabic(String chNo) {
        this.arabic = chNo;
    }
    public String getBangla(){
        return bangla;
    }
    public void setBangla(String vrsNo){
        this.bangla = vrsNo;
    }
}