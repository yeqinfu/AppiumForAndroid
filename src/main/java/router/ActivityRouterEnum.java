package router;

import activityaction.ActivityEnum;

import java.util.List;

/**
 * 定义
 */
public enum  ActivityRouterEnum {
    login(ActivityEnum.loginActivity, new ActivityEnum[]{ActivityEnum.mainActivity})
    ;
    ActivityEnum activityEnum;

    private ActivityEnum[] parentList;


    ActivityRouterEnum(ActivityEnum activityEnum, ActivityEnum[] parentList) {
        this.activityEnum = activityEnum;
        this.parentList = parentList;
    }
}
