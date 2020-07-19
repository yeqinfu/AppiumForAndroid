package router;

import activityaction.ActivityAction;
import activityaction.ActivityEnum;
import io.appium.java_client.android.AndroidDriver;

/**
 * 路由默认实现类
 * 因为app中跳转路径会改
 * 也就是同一个按钮 点击可能跳A B C三个页面，权限控制的原因
 * 所以activity页面路径不能写死 到达一个页面A也可能是有多个
 * 入口也就是多个路径。所以需要处理这些问题
 * 假设我们在一个深度为E的页面 需要后退n步然后到达W页面 从W页面
 * 找到另外一个入口，跳转N次才到达E页面。此算法就是集中解决自动
 * 寻由的过程
 */
public class DefaultRouterImpl implements IRouter{
   private String split="#*_*#";//分隔符


   /**
    * 当前activity 走到指定的activity
    * @param driver
    * @param target
    * @return
    */
   @Override
   public boolean currentToTarget(AndroidDriver driver, ActivityEnum target) {

      ActivityEnum currentActivityEnum=ActivityEnum.getActivityEnumByPath(driver.currentActivity());
      boolean result=currentActivityEnum.tryGoToTarget(driver,target,currentActivityEnum.getChildList());

      //子节点找到了
      if (result==true){
         return true;
      }
      //子节点没找到
      ActivityAction currentAtion=ActivityEnum.getActivityActionByPath(driver,driver.currentActivity());
      currentAtion.popCurrentActivity();
      //变成上层节点
      ActivityEnum parentEnum=ActivityEnum.getActivityEnumByPath(driver.currentActivity());
      for (ActivityEnum parent:parentEnum.getParentList()){
         if (parent!=currentActivityEnum){//刚从这个子节点倒退回来的，所以这里不用再次遍历
            boolean parentResult=currentToTarget(driver,target);
            if (parentResult==true){
               return true;
            }

         }
      }
      return false;
   }
}
