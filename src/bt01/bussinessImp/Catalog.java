package bt01.bussinessImp;

import bt01.bussiness.IShop;

import static bt01.run.ProductManagement.sc;

public class Catalog implements IShop {
    private int catalogId;
    private String catalogName;
    private int priority;
    private String descriptions;
    private boolean catalogStatus;

    public Catalog() {
    }

    public Catalog(int catalogId, String catalogName, int priority, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.priority = priority;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    @Override
    public void inputData() {
        System.out.println("Nhập mã danh mục");
        this.catalogId = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập tên danh mục");
        this.catalogName = sc.nextLine();

        System.out.println("Nhập độ ưu tiên");
        this.priority = Integer.parseInt(sc.nextLine());

        System.out.println("Mô tả danh mục");
        this.descriptions = sc.nextLine();

        System.out.println("Nhập trạng thái");
        this.catalogStatus = Boolean.parseBoolean(sc.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf("Mã danh mục: %d - Tên danh mục: %s\n", this.catalogId, this.catalogName);

    }
}
