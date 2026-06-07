package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.Major;
import org.example.entity.Student;
import org.example.repository.JPAUtils;

import java.math.BigDecimal;
import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        System.out.println("Đang kết nối database...");
//
//        EntityManagerFactory emf = null;
//        EntityManager em = null;
//
//        try {
//            // Bước 1: Tạo EntityManagerFactory (EMF)
//            // - Đọc file persistence.xml, lấy thông tin kết nối (url, user, password)
//            // - Tạo connection pool đến MySQL
//            // - "hsf302" là tên persistence-unit đã khai báo trong persistence.xml
//            // - Nếu persistence.xml sai hoặc MySQL chưa chạy → exception ở đây
//            emf = Persistence.createEntityManagerFactory("hsf302");
//            System.out.println("[OK] EntityManagerFactory tạo thành công!");
//
//            // Bước 2: Tạo EntityManager (EM) từ EMF
//            // - EM là object chính để thao tác database (persist, find, remove...)
//            // - Mỗi lần cần thao tác DB → tạo 1 EM mới từ EMF
//            em = emf.createEntityManager();
//            System.out.println("[OK] EntityManager tạo thành công!");
//
//            // Bước 3: Gửi câu SQL đơn giản nhất để chắc chắn kết nối OK
//            // - "SELECT 1" chỉ trả về số 1, không cần table nào
//            // - Nếu chạy được = MySQL nhận lệnh thành công = kết nối OK
//            em.createNativeQuery("SELECT 1").getSingleResult();
//            System.out.println("[OK] Kết nối MySQL thành công!");
//
//        } catch (Exception e) {
//            // Nếu bất kỳ bước nào lỗi → in ra nguyên nhân
//            System.err.println("[FAIL] Lỗi kết nối: " + e.getMessage());
//            e.printStackTrace();
//        } finally {
//            // Bước 4: Dọn dẹp — luôn đóng EM và EMF khi xong
//            // - Giải phóng connection về pool, tránh rò rỉ tài nguyên
//            if (em != null) em.close();
//            if (emf != null) emf.close();
//        }

        /**
         * persist() -> insert
         * find => tìm kiếm select
         * merge() => update cập nhật bản ghi
         * remove() => delete
         */
        EntityManager em = JPAUtils.getEntityManager();
        em.getTransaction().begin();
        Student s = em.find(Student.class, 3);

        if (s != null ) {
            em.remove(s);
        }

        em.getTransaction().commit();

//        try {
//            em.getTransaction().begin();
//
//            //tao 1 entity moi
//            Student student = new Student("Nguyen Van A", "abc@gmail.com", LocalDate.of(1996, 3, 6),
//                    Major.SOFTWARE_ENGINEERING, new BigDecimal(3.6));
//
//            //luu vao trong DB
//            em.persist(student);
//
//            em.getTransaction().commit();
//
//            System.out.println("Saved: " + student);
//            System.out.println("GENERATE VALUE: " + student.getId());
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            em.close();
//            emf.close();
//        }

    }
}