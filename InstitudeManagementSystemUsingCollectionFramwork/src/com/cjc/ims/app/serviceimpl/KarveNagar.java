package com.cjc.ims.app.serviceimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.cjc.ims.app.model.Batch;
import com.cjc.ims.app.model.Course;
import com.cjc.ims.app.model.Faculty;
import com.cjc.ims.app.model.Student;
import com.cjc.ims.app.servicei.Cjc;

/**
 * KarveNagar class implements the Cjc interface and provides
 * full CRUD operations for managing Course, Faculty, Batch,
 * and Student entities.
 *
 * Flow: Course ➡ Faculty ➡ Batch ➡ Student
 */
public class KarveNagar implements Cjc {

    // ==========================
    // Collections for data store
    // ==========================
    List<Course> clist = new ArrayList<>();
    List<Faculty> flist = new ArrayList<>();
    List<Batch> blist = new ArrayList<>();
    List<Student> slist = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    // Model objects
    Course c = new Course();
    Faculty f = new Faculty();
    Batch b = new Batch();
    Student s = new Student();

    // ======================
    // 1️⃣ Add Course
    // ======================
    @Override
    public void addCourse() {
        System.out.println("Add Course Name: ");
        c.setCname(sc.next());

        System.out.println("Add Course ID: ");
        c.setCid(sc.nextInt());

        clist.add(c);

        System.out.println("✅ Course Added Successfully!");
    }

    // ======================
    // 2️⃣ View Course
    // ======================
    @Override
    public void viewCourse() {
        for (Course course : clist) {
            System.out.println("Course ID: " + course.getCid());
            System.out.println("Course Name: " + course.getCname());
            System.out.println("----------------------------------");
        }
    }

    // ======================
    // 3️⃣ Add Faculty
    // ======================
    @Override
    public void addFaculty() {
        System.out.println("Available Courses:");
        for (Course c : clist) {
            System.out.println("Course ID: " + c.getCid() + " | Course Name: " + c.getCname());
        }

        System.out.println("Enter Course ID to assign to this Faculty:");
        int cid = sc.nextInt();

        Course selectCourse = null;
        for (Course c : clist) {
            if (c.getCid() == cid) {
                selectCourse = c;
                break;
            }
        }

        if (selectCourse == null) {
            System.out.println("❌ Invalid Course ID!");
            return;
        }

        System.out.println("Add Faculty ID: ");
        f.setFid(sc.nextInt());

        System.out.println("Add Faculty Name: ");
        f.setFname(sc.next());

        f.setCourse(selectCourse);
        flist.add(f);

        System.out.println("✅ Faculty Added Successfully!");
    }

    // ======================
    // 4️⃣ View Faculty
    // ======================
    @Override
    public void viewFaculty() {
        for (Faculty faculty : flist) {
            System.out.println("Faculty ID: " + faculty.getFid());
            System.out.println("Faculty Name: " + faculty.getFname());
            System.out.println("Course Name: " + faculty.getCourse().getCname());
            System.out.println("----------------------------------");
        }
    }

    // ======================
    // 5️⃣ Add Batch
    // ======================
    @Override
    public void addBatch() {
        System.out.println("Available Faculty and Course:");
        for (Faculty f : flist) {
            System.out.println("Course Name: " + f.getCourse().getCname());
            System.out.println("Faculty ID: " + f.getFid());
            System.out.println("Faculty Name: " + f.getFname());
        }

        System.out.println("Enter Faculty ID to assign to this Batch:");
        int fid = sc.nextInt();

        Faculty selectFaculty = null;
        for (Faculty f : flist) {
            if (f.getFid() == fid) {
                selectFaculty = f;
                break;
            }
        }

        if (selectFaculty == null) {
            System.out.println("❌ Invalid Faculty ID!");
            return;
        }

        System.out.println("Enter Batch ID:");
        b.setBid(sc.nextInt());

        System.out.println("Enter Batch Name:");
        b.setBname(sc.next());

        b.setFaculty(selectFaculty);
        blist.add(b);

        System.out.println("✅ Batch Added Successfully!");
    }

    // ======================
    // 6️⃣ View Batch
    // ======================
    @Override
    public void viewBatch() {
        for (Batch b : blist) {
            System.out.println("Course ID: " + b.getFaculty().getCourse().getCid());
            System.out.println("Course Name: " + b.getFaculty().getCourse().getCname());
            System.out.println("Faculty ID: " + b.getFaculty().getFid());
            System.out.println("Faculty Name: " + b.getFaculty().getFname());
            System.out.println("Batch ID: " + b.getBid());
            System.out.println("Batch Name: " + b.getBname());
            System.out.println("----------------------------------");
        }
    }

    // ======================
    // 7️⃣ Add Student
    // ======================
    @Override
    public void addStudent() {
        System.out.println("Available Batches and Details:");
        for (Batch b : blist) {
            System.out.println("Course: " + b.getFaculty().getCourse().getCname() +
                               " | Faculty: " + b.getFaculty().getFname() +
                               " | Batch: " + b.getBname());
        }

        System.out.println("Enter Batch ID to assign to this Student:");
        int bid = sc.nextInt();

        Batch selectBatch = null;
        for (Batch b : blist) {
            if (b.getBid() == bid) {
                selectBatch = b;
                break;
            }
        }

        if (selectBatch == null) {
            System.out.println("❌ Invalid Batch ID!");
            return;
        }

        System.out.println("Enter Student ID:");
        s.setSid(sc.nextInt());

        System.out.println("Enter Student Name:");
        s.setSname(sc.next());

        s.setBatch(selectBatch);
        slist.add(s);

        System.out.println("✅ Student Added Successfully!");
    }

    // ======================
    // 8️⃣ View Student
    // ======================
    @Override
    public void viewStudent() {
        for (Student s : slist) {
            System.out.println("Course ID: " + s.getBatch().getFaculty().getCourse().getCid());
            System.out.println("Course Name: " + s.getBatch().getFaculty().getCourse().getCname());
            System.out.println("Faculty ID: " + s.getBatch().getFaculty().getFid());
            System.out.println("Faculty Name: " + s.getBatch().getFaculty().getFname());
            System.out.println("Batch ID: " + s.getBatch().getBid());
            System.out.println("Batch Name: " + s.getBatch().getBname());
            System.out.println("Student ID: " + s.getSid());
            System.out.println("Student Name: " + s.getSname());
            System.out.println("----------------------------------");
        }
    }
}
