package com.TeachAway.qa.MainPage;

import com.TeachAway.qa.base.TestBase;

public class MenuItems extends TestBase {
    public MenuItems(){super();}
    public static void main(String[] args) throws InterruptedException {
        MenuItems menu = new MenuItems();
        initialization();
        SelectJobs();
        SelectTEFL();
        SelectTeacherCertification();
        SelectCourses();
        SelectHireTeachers();
    }

}
