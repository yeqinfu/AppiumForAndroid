package activityaction;

/**
 * 在一个activity可能出现的操作抽象
 * 每一个activity需要完成到这个activity到此技或者上级页面的所有操作
 *
 */
public interface ActivityAction {
    //退出当前activity
    void popCurrentActivity();
    void toLoginActivity();
}