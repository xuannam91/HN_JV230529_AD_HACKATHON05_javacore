package bt01.bussinessImp;

import bt01.bussiness.IShop;
import bt01.run.ProductManagement;

import static bt01.run.ProductManagement.*;

public class Product implements IShop {
    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    private Catalog catalog;
    private float importPrice;
    private float exportPrice;
    private boolean productStatus;

    public Product() {
    }

    public Product(int productId, String productName, String title, String descriptions, Catalog catalog, float importPrice, float exportPrice, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.productStatus = productStatus;
    }


    @Override
    public void inputData() {
        System.out.println("Nhập mã sản phẩm");
        this.productId = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập tên sản phẩm");
        this.productName = sc.nextLine();

        System.out.println("Nhập tiêu đề sản phẩm");
        this.title = sc.nextLine();

        System.out.println("Mô tả sản phẩm");
        this.descriptions = sc.nextLine();

        System.out.println("Chọn mã Danh mục");
        if (catalogList.isEmpty()) {
            System.out.println("Danh mục chưa tồn tại, hãy nhập danh mục");
            ProductManagement.saveCatalog();
            forListcata();
        } else {
            forListcata();
        }
        System.out.println("Giá nhập");
        this.importPrice = Float.parseFloat(sc.nextLine());

        this.exportPrice = this.importPrice* RATE;

        System.out.println("Nhập trạng thái");
        this.productStatus = Boolean.parseBoolean(sc.nextLine());

    }

    // phương thức lựa chọn catalog
    public void forListcata() {
        boolean isExit = true;
        do {
            for (int i = 0; i < catalogList.size(); i++) {
               catalogList.get(i).displayData();
            }

            System.out.println("Nhập mã ID Catalog bạn cần cho sản phẩm");
            int catalogID = Integer.parseInt(sc.nextLine());
            boolean check = false;
            for (Catalog cataItem : catalogList) {
                if (cataItem.getCatalogId() == catalogID) {
                    this.catalog = cataItem;
                    check = true;
                }
            }
            if (check) {
                break;
            } else {
                System.out.println("Yêu cầu nhập đúng Mã danh mục tồn tại");
            }

        } while (isExit);
    }


    @Override
    public void displayData() {
        System.out.printf("Mã sản phẩm: %d - Tên sản phẩm: %s \n", this.productId, this.productName);
        System.out.printf("Tên danh mục: %s - Giá bán: %f - Trạng thái: %s \n", this.catalog.getCatalogName(), this.exportPrice, this.productStatus?"con hang":"het hang");
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }
}
