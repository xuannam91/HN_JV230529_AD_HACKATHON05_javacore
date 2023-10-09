package bt01.run;

import bt01.bussinessImp.Catalog;
import bt01.bussinessImp.Product;

import java.util.*;

public class ProductManagement {
    public static Scanner sc = new Scanner(System.in);
    public static List<Catalog> catalogList = new ArrayList<>();
    public static List<Product> productList = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("=====-ADVANCE-MENU====");
            System.out.println("1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục");
            System.out.println("2. Nhập số sản phẩm và nhập thông tin các sản phẩm");
            System.out.println("3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần ");
            System.out.println("4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm");
            System.out.println("5. Thoát");
            System.out.println("Lựa chọn yêu cầu");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    saveCatalog();
                    break;
                case 2:
                    saveProduct();
                    break;
                case 3:
                    sortUpPrice();
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    System.out.println("Đã thoát");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn 1 -> 5. Vui lòng thử lại.");
            }
        } while (true);
    }

    // 1.Nhập số danh mục sản phẩm và nhập thông tin các danh mục

    public static void saveCatalog(){
        System.out.print("Nhập số lượng danh mục cần thêm : ");
        int numCataToAdd = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numCataToAdd; i++) {
            System.out.println("Danh mục thêm thứ: " + (i+1));
            Catalog catalogNew = new Catalog();
            catalogNew.inputData();
            catalogList.add(catalogNew);
        }
    }

    // 2. Nhập số sản phẩm và nhập thông tin các sản phẩm

    public static void saveProduct(){
        System.out.print("Nhập số lượng sản phẩm cần thêm : ");
        int numProductToAdd = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numProductToAdd; i++) {
            System.out.println("Sản phẩm thêm thứ: " + (i+1));
            Product productNew = new Product();
            productNew.inputData();
            productList.add(productNew);
        }
    }


    //3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần
    public static void sortUpPrice() {
        productList.sort(Comparator.comparing(Product::getExportPrice));
        for (Product element : productList) {
            element.displayData();
        }
    }

    //4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm
    public static void search() {
        System.out.println("Nhập tên danh mục để tìm sản phẩm");
        String searchNameCata = sc.nextLine();
        boolean check = false;
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getCatalog().getCatalogName().toLowerCase().contains(searchNameCata.toLowerCase())){
                productList.get(i).displayData();
                check = true;
            }
        }
        if (!check) {
            System.out.println("Sản phẩm không tìm thấy");
        }
    }
}
