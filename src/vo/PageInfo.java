package vo;

import java.util.List;

public class PageInfo<T> {
    private int currentPage;    // 当前页码
    private int pageSize;       // 每页记录数
    private int totalRecord;    // 总记录数
    private int totalPage;      // 总页数
    private List<T> list;       // 当前页数据

    public PageInfo(int currentPage, int pageSize, int totalRecord, List<T> list) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        this.list = list;
        // 计算总页数（向上取整）
        this.totalPage = (int) Math.ceil((double) totalRecord / pageSize);
    }

    // 省略 Getter 和 Setter（如需修改分页参数时使用）
    public int getCurrentPage() { return currentPage; }
    public int getPageSize() { return pageSize; }
    public int getTotalRecord() { return totalRecord; }
    public int getTotalPage() { return totalPage; }
    public List<T> getList() { return list; }
}