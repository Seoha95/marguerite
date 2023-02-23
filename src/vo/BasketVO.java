package vo;

public class BasketVO {
   private String id;
   private String code;
   private String pname;
   private String category;
   private int count;
   private String psize;
   private int price;
   private String pimage;
   
   public BasketVO() {}

   public BasketVO(String id, String code, String pname, String category,
         int count, String psize, int price, String pimage) {
      this.id = id;
      this.code = code;
      this.pname = pname;
      this.category = category;
      this.count = count;
      this.psize = psize;
      this.price = price;
      this.pimage = pimage;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getCode() {
      return code;
   }

   public void setCode(String code) {
      this.code = code;
   }

   public String getPname() {
      return pname;
   }

   public void setPname(String pname) {
      this.pname = pname;
   }

   public String getCategory() {
      return category;
   }

   public void setCategory(String category) {
      this.category = category;
   }

   public int getCount() {
      return count;
   }

   public void setCount(int count) {
      this.count = count;
   }

   public String getPsize() {
      return psize;
   }

   public void setPsize(String psize) {
      this.psize = psize;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public String getPimage() {
      return pimage;
   }

   public void setPimage(String pimage) {
      this.pimage = pimage;
   }
   
}