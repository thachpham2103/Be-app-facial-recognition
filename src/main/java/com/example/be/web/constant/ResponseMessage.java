package com.example.be.web.constant;

public class ResponseMessage {

    public final static String RATING_SCORE="Score must be between 1 and 5";

    public static final String DELETE_SUCCESS = "Successfully deleted ";
    public static final String CHANGE_PASSWORD_SUCCESS = "Password changed successfully.";

    public static final String REGISTER_SUCCESS = "Registration successful.";
    public static final String APPROVE_REJECT_SUCCESS = "Successfully processed the application.";
    public static final String DELETES_SUCCESS = "Successfully deleted the registration form.";
    public static final String CANCEL_SUCCESS = "Unsubscription successful.";

    public static final String FETCH_SUCCESS = "Data retrieved successfully.";
    public static final String UPDATE_SUCCESS = "Successfully updated.";
    public static final String CREATE_SUCCESS = "Successfully created.";
    public static final String ACTION_SUCCESS = "Operation successful.";
    public static final String MARK_AS_READ_SUCCESS = "Đã đánh dấu đọc";

    public static class Auth {
        public static final String CHANGE_PASSWORD_SUCCESS = "Đổi mật khẩu thành công";
    }

    public static class Assignment {
        public static final String DELETE_SUBMISSION_SUCCESS = "Đã xóa bài nộp thành công";
    }

    public static class AttendanceAdvanced {
        public static final String DELETE_POLICY_SUCCESS = "Đã xóa chính sách điểm danh";
        public static final String DELETE_WARNING_SUCCESS = "Đã xóa cảnh báo";
        public static final String DELETE_APPEAL_SUCCESS = "Đã xóa giải trình thành công";
    }

    public static class Chat {
        public static final String DELETE_MESSAGE_SUCCESS = "Đã xóa tin nhắn";
        public static final String TOGGLE_PIN_SUCCESS = "Đã thay đổi trạng thái ghim";
        public static final String JOIN_REQUEST_SENT = "Đã gửi yêu cầu tham gia nhóm";
        public static final String JOIN_REQUEST_APPROVED = "Đã duyệt yêu cầu";
        public static final String JOIN_REQUEST_REJECTED = "Đã từ chối yêu cầu";
    }

    public static class Face {
        public static final String REGISTER_SUCCESS = "Registered";
    }

    public static class LearningTask {
        public static final String CANCEL_SUCCESS = "Đã hủy nhiệm vụ";
    }

    public static class Notification {
        public static final String DELETE_SUCCESS = "Đã xóa thông báo";
        public static final String SEND_SUCCESS = "Đã gửi thông báo";
        public static final String UPDATE_SUCCESS = "Đã cập nhật thông báo";
        public static final String DEACTIVATE_TEMPLATE_SUCCESS = "Đã vô hiệu hóa template";
    }

    public static class User{

        public final static String USER_DELETE="user successful!";

    }

    public static final String CHANGE_STORY ="The liking status has been changed.";
}
