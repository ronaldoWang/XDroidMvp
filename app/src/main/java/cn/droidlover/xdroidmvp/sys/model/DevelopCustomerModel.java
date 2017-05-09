package cn.droidlover.xdroidmvp.sys.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.droidlover.xdroidmvp.net.IModel;

/**
 * Created by haoxi on 2017/4/25.
 */

public class DevelopCustomerModel extends BaseModel<List<DevelopCustomerModel.DevelopCustomer>> implements IModel {

    public static class DevelopCustomer {
        private String customerName; // 客户名称
        private String customerNo; // 客户编号
        private String sex; // 性别
        private String mobilePhone; // 手机
        private String summary; // 概况
        private String type;// 客户类型
        private String email;// 邮箱
        private Date recentDate;// 最近一次沟通时间
        private String recentResult;// 最近一次沟通内容
        private String search;// 搜索内容（客户名称|手机|概况|客户类型）


        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getCustomerNo() {
            return customerNo;
        }

        public void setCustomerNo(String customerNo) {
            this.customerNo = customerNo;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getMobilePhone() {
            return mobilePhone;
        }

        public void setMobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Date getRecentDate() {
            return recentDate;
        }

        public void setRecentDate(Date recentDate) {
            this.recentDate = recentDate;
        }

        public String getRecentResult() {
            return recentResult;
        }

        public void setRecentResult(String recentResult) {
            this.recentResult = recentResult;
        }

        public String getSearch() {
            return search;
        }

        public void setSearch(String search) {
            this.search = search;
        }

        public Map<String, Object> getDataMap() {
            Map<String, Object> map = new HashMap<>();
            map.put("customerName", customerName);
            map.put("customerNo", customerNo);
            map.put("sex", sex);
            map.put("mobilePhone", mobilePhone);
            map.put("summary", summary); // 概况
            map.put("type", type);// 客户类型
            map.put("email", email);// 邮箱
            map.put("recentDate", recentDate);// 最近一次沟通时间
            map.put("recentResult", recentResult);// 最近一次沟通内容
            map.put("search", search);// 搜索内容（客户名称|手机|概况|客户类型）
            return map;
        }
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public boolean isAuthError() {
        return false;
    }

    @Override
    public boolean isBizError() {
        return false;
    }

    @Override
    public String getErrorMsg() {
        return null;
    }
}
