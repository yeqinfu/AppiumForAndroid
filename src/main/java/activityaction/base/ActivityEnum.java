package activityaction.base;

import activityaction.*;
import io.appium.java_client.android.AndroidDriver;
import utils.Utils;

/**
 * 页面路由清单
 */
public enum ActivityEnum {
    TrainActivity(".ui.list.training.TrainActivity", TrainActivityAction.class),
    AccDinnerActivity(".ui.list.dinner.AccDinnerActivity", AccDinnerActivityAction.class),
    RiskWarningActivity(".ui.list.riskwarning.RiskWarningActivity", RiskWarningActivityAction.class),
    SupplierTraceActivity(".ui.list.supplier.SupplierTraceActivity", SupplierTraceActivityAction.class),
    ReservedRecordActivity(".ui.list.samplereserved.ReservedRecordActivity", ReservedRecordActivityAction.class),
    PersonHealthyActivity(".ui.list.healthy.PersonHealthyActivity", PersonHealthyActivityAction.class),
    DisinfectManagerActivity(".ui.list.disinfectmanager.DisinfectManagerActivity", DisinfectManagerActivityAction.class),
    MaterialAddActivity(".ui.list.materialmanager.MaterialAddActivity", MaterialAddActivityAction.class),
    MaterialManagerActivity(".ui.list.materialmanager.MaterialManagerActivity", MaterialManagerActivityAction.class),
    ManagerOperateActivity(".ui.list.platform.ManagerOperateActivity", ManagerOperateActivityAction.class),
    OperateChooseActivity(".ui.list.platform.OperateChooseActivity", OperateChooseActivityAction.class),
    AboutActivity(".ui.me.AboutActivity", AboutActivityAction.class),
    SettingActivity(".ui.me.SettingActivity", SettingActivityAction.class),
    MainActivity(".ui.MainActivity", MainActivityAction.class),
    NetSettingActivity(".ui.NetSettingActivity", NetSettingActivityAction.class),
    LoginActivity(".ui.LoginActivity",LoginActivityAction.class),
    LaunchActivity(  ".ui.launchActivity",  LaunchActionAction.class),
    MultiImageSelectorActivity("me.nereo.multi_image_selector.MultiImageSelectorActivity", MultiImageSelectorActivityAction.class),


    ;

    public static ActivityAction getActivityActionByPath(AndroidDriver driver) {
        return getActivityActionByPath(driver, driver.currentActivity());
    }

    public static ActivityAction getActivityActionByPath(AndroidDriver driver, String path) {
        ActivityEnum target = getActivityEnumByPath(path);
        if (target == null) {
            return null;
        }
        try {
            return target.activityActionClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;

    }


    String activityPath;
    //对应的action
    Class<BaseActivityAction> activityActionClass;

    public Class<BaseActivityAction> getActivityActionClass() {
        return activityActionClass;
    }

    public void setActivityActionClass(Class<BaseActivityAction> activityActionClass) {
        this.activityActionClass = activityActionClass;
    }

    <T extends BaseActivityAction> ActivityEnum(String activityPath, Class<T> activityActionClass) {
        this.activityPath = activityPath;
        this.activityActionClass = (Class<BaseActivityAction>) activityActionClass;
    }


    public static ActivityEnum getActivityEnumByPath(String path) {
        for (ActivityEnum item : ActivityEnum.values()) {
            if (item.activityPath.equals(path)) {
                return item;
            }
        }
        return null;
    }


    /**
     * 判断理论路径是否可行
     *
     * @param source 为了避免循环
     * @param target
     * @return
     */
    public boolean canGoToTarget(ActivityEnum source, ActivityEnum target) {
        if (this == target) {
            return true;
        }
        try {
            ActivityAction current = activityActionClass.newInstance();

            for (ActivityEnum child : current.getChildActivityEnum()) {
                if (child != source && child.canGoToTarget(source, target)) {
                    return true;
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean tryGoToTarget(AndroidDriver driver, ActivityEnum target, ActivityEnum[] tempChildList) {
        Utils.print("当前节点" + this.activityPath);
        Utils.print("目标节点" + target.activityPath);
        //当前就是指定要到的节点
        if (this == target) {
            return true;
        }
        //孩子节点是否可以进去
        for (ActivityEnum child : tempChildList) {
            if (child.canGoToTarget(this, target)) {//子列表可以进去
                //无条件相信
                ActivityAction currentAction = ActivityEnum.getActivityActionByPath(driver, activityPath);

                Utils.print("尝试进入当前节点" + this.activityPath + "的子节点" + child.activityPath);
                boolean result = currentAction.goToChild(driver, child);
                if (result) {//进入成功
                    Utils.print("进入子节点成功" + child.activityPath);
                    ActivityAction childActivityAction = ActivityEnum.getActivityActionByPath(driver, child.activityPath);
                    boolean dd = child.tryGoToTarget(driver, target, childActivityAction.getChildActivityEnum());
                    if (dd == true) {

                        return true;
                    } else {
                        ActivityEnum.getActivityActionByPath(driver, driver.currentActivity()).popCurrentActivity();
                        return false;
                    }
                } else {
                    Utils.print("进入子节点失败 " + child.activityPath);
                    ActivityEnum newActivityEnum = ActivityEnum.getActivityEnumByPath(driver.currentActivity());
                    //策略1 失败就直接退一级
                    //currentAction.popCurrentActivity();
                    //策略2 失败还是得判断是否进入到别的页面 是，才退出 不是 不退出
                    //比较智能 但是无法克服 A->A也就是点击本来应该进入B 结果进入到A 恰巧上一级还是A 这样得话就卡在这里了
                    //最后决定不支持A->A这种方式
                    if (newActivityEnum == this) {//如果尝试进入子节点一动不动 就不做动作

                    } else {
                        currentAction.popCurrentActivity();
                    }


                }
            }
        }
        Utils.print("没有其他子节点可以进去");
        return false;
    }


    public String getActivityPath() {
        return activityPath;
    }

    public void setActivityPath(String activityPath) {
        this.activityPath = activityPath;
    }
}
