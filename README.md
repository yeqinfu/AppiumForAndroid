# AppiumForAndroid
基于Appium测试工具，使用testng测试框架作为基础的Java工程，用来测试Android项目（不仅限于）
### 本工程的主要内容
测试的时候，比如多个Activity跳转逻辑,这里封装了任意目的地的跳转路由算法，大概是使用了树深度搜索的算法，帮助我们实现任意acitivity跳转，举例子
### 场景

app的Activity跳转其实是比较多样的，最简答的比如A B C D页面跳转顺序可能是

+ A->B->C->D
+ A->B->A->C->D->A

> 总结 特点1：就是可能是一个跳转循环

跳转路径组成可能是一颗树，树的子节点可能是重复的大概如图

![image](https://tva1.sinaimg.cn/large/c1b251b3gy1ggxml0dbvkj20jf0avwf4.jpg)

> 总结特点2 它是一颗树

所以，我们在写一个功能的时候，比如D做完一件事，要跳到G页面去查看，那么这个测试流程，包含页面跳转的部分，是否可以由算法直接解决，而我们只需要集中写在D页面做的一件事的内容，和在G页面做的另一件事的内容就可以。跳转的部分我希望是一句代码解决。

此外有另外一个场景，比如一个页面的按钮btn，有时候点击进去是A页面有时候点击进去是B页面它是不确定的，我们只能确定当前页面是可能到达A B页面，但是具体能不能到达我们也不知道。得你点击了跳转了，才能知道是到达了A还是到达了B

> 总结特点3 节点到达子节点 具体能否到达不能够确定

### 具体算法

我们定义了一个基本概念ActivityAction，具体得某个页面点击操作都是继承这个类来完成得，比如主页面MainActivityAction,我们在新建一个页面的时候，必须实现两个方法，第一退出这个页面的方法实现，第二，到达这个页面所有的子节点的方法实现。

```

/**
 * 在一个activity可能出现的操作抽象
 * 每一个activity需要完成到这个activity到此技或者上级页面的所有操作
 *
 */
public interface ActivityAction {
    。。。
    //退出当前activity
    void popCurrentActivity();
    boolean goToChild(AndroidDriver driver, ActivityEnum child);
    。。。
}

```

假设我们在根节点A（最顶部的A）的位置。我们要去B页面。如图所示我们有两种走法

+ A->B
+ A->D->F->B

算法第一部分就是向下（子节点）寻找要到的地方。

根节点的A它是有三个子节点，通过深度优先搜索树的形式去判断A的子节点是否有到B的路径。我们这里假设有

+ 情况1 恰好A的一个还是就是B，那么就直接到了

+ 情况2 A直接子节点虽然在定义上，理论可以到达，但是因为权限或者其他原因始终到不了，那么A的子节点将继续遍历 最终找打第二条路A->D->F->B

+ 情况3 A的所有的节点都不能到B，那么A只能向上跳 例如

  > B要到G B的孩子节点都到不了，B就只能向上退出，到A的位置，最终找到
  >
  > B->A->D->G这样一个一次返回两次前进的功能

所以我们在定义一个页面的时候，要实现这个页面的后退功能，还有所有的前进功能，前进之后还要判断是否真的到达了指定页面，如果到了就说明前进成功，如果没到就是没成功，需要立马跳回来。

>  此外还需要避免路由死循环，路过的节点不能再次深度搜索。

最后无论想怎么折腾页面的跳转，都是一句话搞定

```
 @Override
    public void startTest() {
        super.startTest();
        //执行进入关于产品页面
         iRouter.currentToTarget(driver, ActivityEnum.AboutActivity);
        //执行进入设置页面
          iRouter.currentToTarget(driver,ActivityEnum.SettingActivity);
        //执行进入 管理操作-八个菜单
         iRouter.currentToTarget(driver,ActivityEnum.ManagerOperateActivity);

        //执行进入食材管理
        iRouter.currentToTarget(driver, ActivityEnum.MaterialManagerActivity);
        //消毒管理
        iRouter.currentToTarget(driver, ActivityEnum.DisinfectManagerActivity);

        //人员健康
        iRouter.currentToTarget(driver, ActivityEnum.PersonHealthyActivity);

        //返回主页
        iRouter.currentToTarget(driver, ActivityEnum.MainActivity);
        //留样管理
        iRouter.currentToTarget(driver, ActivityEnum.ReservedRecordActivity);
        iRouter.currentToTarget(driver,ActivityEnum.AboutActivity);

    }
```

如上，跳转页面流程可以变得简洁。而具体的操作，比如提交任务，则在具体的ActivityAction完成

```

public class MaterialAddActivityAction extends BaseActivityAction{
    public MaterialAddActivityAction(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public void doAllActions() {
        super.doAllActions();
        //设置页面内容工作
        //条码
        findItemInputView("iivBarCode","测试条码001");
        //选择品名
        clickDelay("iivProductName");
        //选择一个默认的第一个产品
        clickDelay("tvSure");
        //数量3
        findItemInputView("iivPurchaseNumber","3");
        //滑动
        swipeUp();
        //选择图片
        clickDelay("ivAddImage");
        new MultiImageSelectorActivityAction(driver).selectPic();
        //继续滑动
       // swipeUp();
        //提交
        clickDelay("tvSubmit");
        //
    }
```


