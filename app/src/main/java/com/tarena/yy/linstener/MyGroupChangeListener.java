package com.tarena.yy.linstener;

import com.hyphenate.EMGroupChangeListener;

import java.util.List;

/**
 * Created by tarena on 2017/7/11.
 */

public class MyGroupChangeListener implements EMGroupChangeListener{
    @Override
    public void onInvitationReceived(String groupId, String groupName, String inviter, String reason) {
        //接收到群组加入邀请

    }

    @Override
    public void onRequestToJoinReceived(String groupId, String groupName, String applicant, String reason) {
        //用户申请加入群

    }

    @Override
    public void onRequestToJoinAccepted(String groupId, String groupName, String accepter) {
        //加群申请被同意

    }

    @Override
    public void onRequestToJoinDeclined(String groupId, String groupName, String decliner, String reason) {
        //加群申请被拒绝
    }

    @Override
    public void onInvitationAccepted(String groupId, String invitee, String reason) {
        //群组邀请被同意
    }

    @Override
    public void onInvitationDeclined(String groupId, String invitee, String reason) {
        //群组邀请被拒绝
    }

    @Override
    public void onUserRemoved(String groupId, String groupName) {

    }

    @Override
    public void onGroupDestroyed(String groupId, String groupName) {

    }

    @Override
    public void onAutoAcceptInvitationFromGroup(String groupId, String inviter, String inviteMessage) {

    }

    @Override
    public void onMuteListAdded(String groupId, List<String> mutes, long muteExpire) {

    }

    @Override
    public void onMuteListRemoved(String groupId, List<String> mutes) {

    }

    @Override
    public void onAdminAdded(String groupId, String administrator) {

    }

    @Override
    public void onAdminRemoved(String groupId, String administrator) {

    }

    @Override
    public void onOwnerChanged(String groupId, String newOwner, String oldOwner) {

    }
}
