<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div>
    <h3 class="text-center">ĐĂNG NHẬP HỆ THỐNG</h3>
    <form action="http://localhost:8080/login" method="post">
        <div class="form-group">
            <label>Email</label>
            <input type="email" class="form-control" name="email">
        </div>
        <div class="form-group">
            <label>Mật khẩu</label>
            <input type="password" class="form-control" name="password">
        </div>
        <button type="submit" class="btn btn-primary">Đăng nhập</button>
    </form>
</div>
</body>
</html>
