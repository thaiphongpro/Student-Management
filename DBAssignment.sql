CREATE DATABASE FPL_DaoTao1
GO
USE FPL_DaoTao1
GO

CREATE TABLE GRADE(
    ID INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    MASV NVARCHAR(50) FOREIGN KEY REFERENCES STUDENTS(MASV),
    TIENGANH INT,
    TINHOC INT,
    GDTC INT
)

CREATE TABLE STUDENTS(
    MASV NVARCHAR(50) PRIMARY KEY NOT NULL,
    HOTEN NVARCHAR(50),
    EMAIL NVARCHAR(50),
    SODT NVARCHAR(15),
    GIOITINH BIT,
    DIACHI NVARCHAR(50),
    HINH NVARCHAR(50),
)

CREATE TABLE USERS(
    USERNAME NVARCHAR(50) NOT NULL,
    PASSWORD NVARCHAR(50),
    ROLE NVARCHAR(50)
)

INSERT INTO GRADE(MASV,TIENGANH,TINHOC,GDTC)
VALUES
    (N'TH04120',10,10,9),
    (N'TH04121',9,10,9),
    (N'TH04122',8,10,9),
    (N'TH04123',7,8,9),
    (N'TH04124',5,10,9)

INSERT INTO STUDENTS(MASV,HOTEN,EMAIL,SODT,GIOITINH,DIACHI,HINH)
VALUES
    (N'TH04120',N'Nguyen Thai Phong',N'phongntth04120@fpt.edu.vn',N'0327487001',1,N'Dan Phuong, Ha Noi','phong.jpg'),
    (N'TH04121',N'Nguyen Quynh Nga',N'ngaqnth04120@fpt.edu.vn',N'0123123412',0,N'Hoan Kiem, Ha Noi','nga.jpg'),
    (N'TH04122',N'Nguyen Khanh Linh',N'linhnkth01234@fpt.edu.vn',N'32312312',0,N'Dong Da, Ha Noi','linh.jpg'),
    (N'TH04123',N'Nguyen Quynh Anh',N'anhqnth12345@fpt.edu.vn',N'0327117001',0,N'Cau Giay, Ha Noi','wuynhanh.jpg'),
    (N'TH04124',N'Pham Ha Anh',N'anhphth04444@fpt.edu.vn',N'03117487001',1,N'Ha Dong, Ha Noi','anhha.jpg'),
    (N'TH04125',N'Dinh Quang Duy',N'duydqth12345@fpt.edu.vn',N'9090909090',1,N'Hai Ba Trung, Ha Noi','anhha.jpg'),
    (N'TH04126',N'Pham Mai Huong',N'huongktth12345@fpt.edu.vn',N'123456789',1,N'Hoan Kiem, Ha Noi','anhha.jpg'),
    (N'TH04127',N'Nguyen Van Hieu',N'hietnvth04120@gmail.com',N'1234567',1,N'Ha Noi','anhha.jpg'),
    (N'TH04128',N'Nguyen Mai Linh',N'linhnmth04120@gmail.com',N'123456711',1,N'Ha Noi','anhha.jpg'),
    (N'TH04129',N'Pham Quynh Anh',N'quynhanh04120@gmail.com',N'1234567112',1,N'Ha Noi','anhha.jpg')

INSERT INTO USERS(USERNAME,[PASSWORD],ROLE)
VALUES
    (N'nguyenthaiphong',N'123456aa',N'DaoTao'),
    (N'nguyenkhanhlinh',N'123456aa',N'GiangVien')

SELECT * FROM GRADE

SELECT * FROM STUDENTS

SELECT * FROM USERS

SELECT 1 
FROM USERS 
WHERE username = 'nguyenthaiphong' 
  AND password = '123456aa'

UPDATE STUDENTS SET HOTEN = ?, EMAIL = ?, SODT = ?, GIOITINH = ?, DIACHI = ?, HINH = ? WHERE MASV = ?

UPDATE GRADE SET TIENGANH = ?, TINHOC = ?, GDTC = ? WHERE MASV = ?

SELECT G.ID, G.MASV, S.HOTEN, G.TIENGANH, G.TINHOC, G.GDTC FROM GRADE G INNER JOIN STUDENTS S ON G.MASV = S.MASV WHERE G.MASV = ?

SELECT G.ID, G.MASV, S.HOTEN, G.TIENGANH, G.TINHOC, G.GDTC, ROUND((G.TIENGANH + G.TINHOC + G.GDTC) / 3.0,2) AS avgDiem FROM GRADE G INNER JOIN STUDENTS S ON G.MASV = S.MASV

DROP TABLE STUDENTS