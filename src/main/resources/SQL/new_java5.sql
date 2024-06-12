create database demoJava5;
 use demoJava5

 CREATE TABLE Account (
    id INT PRIMARY KEY IDENTITY(1,1),
    username NVARCHAR(255) NOT NULL,
    password NVARCHAR(255) NOT NULL,
    email NVARCHAR(255) NOT NULL
);

CREATE TABLE LoaiSanPham (
    LSPID INT PRIMARY KEY IDENTITY(1,1),
    TenLoaiSanPham VARCHAR(255) NOT NULL
);

CREATE TABLE SanPham (
    id INT PRIMARY KEY IDENTITY(1,1),
    LSPID int NOT NULL,
	tenSP NVARCHAR(255) NOT NULL,
    Gia money ,
    FOREIGN KEY (LSPID) REFERENCES LoaiSanPham(LSPID)
);

CREATE TABLE HoaDon (
    MaHD INT PRIMARY KEY IDENTITY(1,1),
    Ngay DATETIME NOT NULL,
    TongTien float
);

CREATE TABLE HoaDonChiTiet (
    MaHD INT PRIMARY KEY IDENTITY(1,1),
    ID INT,
    SoLuong INT,
    Gia DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD),
    FOREIGN KEY (id) REFERENCES SanPham(id)
);

SET IDENTITY_INSERT [dbo].[Account] ON 

INSERT [dbo].[Account] ([id], [username], [password], [email]) VALUES (22, N'nhuthai', N'$2a$10$TvBF3qD3KZYnn.nMi/2VhOWpJe/mtNODJpczvMPxqBVf/vLXy1Q2W', N'lenhuthai2706@gmail.com')
INSERT [dbo].[Account] ([id], [username], [password], [email]) VALUES (23, N'nhuthai1', N'$2a$10$wVhyPDYrdXhO8i1GDarDs.XMmTUgoSPBrzwDAfg4.LfNf5bX59VL6', N'lenhuthai2706@gmail.com')
INSERT [dbo].[Account] ([id], [username], [password], [email]) VALUES (24, N'nhuthai5555', N'$2a$10$2vU6ao3dXlsyb2WbLWG8keSVfq6Db3kjiTuv5ATAKczgxEW5ysyaW', N'lenhuthai2706@gmail.com')
SET IDENTITY_INSERT [dbo].[Account] OFF

select * from Account
