import com.design.create.factory.design.ICommodity;
import com.design.create.factory.design.StoreFactory;
import org.junit.Test;

/**
 * @author wangyuj
 * @date 2020/10/29
 **/
public class APITest {
    @Test
    public void test_sendCommodity() {
        StoreFactory storeFactory = new StoreFactory();
        ICommodity commodityService = storeFactory.getCommodityService(1);
        commodityService.sendCommodity();

    }
}
