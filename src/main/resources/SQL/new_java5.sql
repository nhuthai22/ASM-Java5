CREATE DATABASE ASM_Java55;
USE ASM_Java55;

CREATE TABLE Account (
    id INT PRIMARY KEY IDENTITY(1,1),
    username NVARCHAR(255) NULL,
    password NVARCHAR(255) NULL,
    email NVARCHAR(255) NULL
);

CREATE TABLE LoaiSanPham (
    LSPID INT PRIMARY KEY IDENTITY(1,1),
    TenLoaiSanPham NVARCHAR(255) NULL
);

CREATE TABLE SanPham (
    id INT PRIMARY KEY IDENTITY(1,1),
    LSPID INT NULL,
    TenSP NVARCHAR(255) NULL,
    Gia MONEY,
    quantity INT NULL,
    mo_ta NVARCHAR(255) NULL,
    images NVARCHAR(255),
    FOREIGN KEY (LSPID) REFERENCES LoaiSanPham(LSPID)
);

CREATE TABLE HoaDon (
    MaHD INT PRIMARY KEY IDENTITY(1,1),
    Ngay DATETIME NOT NULL,
    TongTien FLOAT
);

CREATE TABLE HoaDonChiTiet (
    MaHD INT,
    ID INT,
    SoLuong INT,
    Gia DECIMAL(10, 2) NULL,
    FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD),
    FOREIGN KEY (ID) REFERENCES SanPham(id),
    PRIMARY KEY (MaHD, ID)
);

SET IDENTITY_INSERT [dbo].[Account] ON 

INSERT [dbo].[Account] ([id], [username], [password], [email]) VALUES (22, N'nhuthai', N'$2a$10$TvBF3qD3KZYnn.nMi/2VhOWpJe/mtNODJpczvMPxqBVf/vLXy1Q2W', N'lenhuthai2706@gmail.com')
INSERT [dbo].[Account] ([id], [username], [password], [email]) VALUES (23, N'nhuthai1', N'$2a$10$wVhyPDYrdXhO8i1GDarDs.XMmTUgoSPBrzwDAfg4.LfNf5bX59VL6', N'lenhuthai2706@gmail.com')
INSERT [dbo].[Account] ([id], [username], [password], [email]) VALUES (24, N'nhuthai5555', N'$2a$10$2vU6ao3dXlsyb2WbLWG8keSVfq6Db3kjiTuv5ATAKczgxEW5ysyaW', N'lenhuthai2706@gmail.com')
SET IDENTITY_INSERT [dbo].[Account] OFF


INSERT INTO LoaiSanPham (TenLoaiSanPham) VALUES
    (N'Trà'),
    (N'Bánh');

INSERT INTO SanPham (LSPID, TenSP, Gia, quantity, mo_ta, images) VALUES
    (1, 'Trà sữa trân châu đen', 35000.00, 5, 'Trà sữa thơm ngon kết hợp với trân châu đen dai ngon', 'https://example.com/tea1.jpg'),
    (1, 'Trà sữa trân châu trắng', 38000.00, 6, 'Trà sữa thơm ngon kết hợp với trân châu trắng mềm mịn', 'https://example.com/tea2.jpg'),
    (1, 'Trà sữa matcha', 40000.00, 7, 'Trà sữa thơm ngon vị matcha đặc trưng', 'https://example.com/tea3.jpg'),
    (1, 'Trà sữa hoa quả', 42000.00, 8, 'Trà sữa thơm ngon vị hoa quả tươi mát', 'https://example.com/tea4.jpg'),
    (1, 'Trà sữa socola', 38000.00, 9, 'Trà sữa thơm ngon vị socola đậm đà nhất', 'https://example.com/tea5.jpg'),
    (2, 'Bánh tráng cuốn', 15000.00, 10, 'Bánh tráng cuốn thịt, rau sống và gia vị', 'https://example.com/cake1.jpg'),
    (2, 'Bánh bao', 12000.00, 8, 'Bánh bao nhân thịt, hấp mềm và ngon', 'https://example.com/cake2.jpg');