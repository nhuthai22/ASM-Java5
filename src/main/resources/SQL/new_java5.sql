DROP DATABASE ASM_Java55;
CREATE DATABASE ASM_Java55;
USE ASM_Java55;

CREATE TABLE Account (
                         id INT PRIMARY KEY IDENTITY(1,1),
                         username NVARCHAR(255) NULL,
                         password NVARCHAR(255) NULL,
                         email NVARCHAR(255) NULL
);

CREATE TABLE Loai_San_Pham (
                               LSPID INT PRIMARY KEY IDENTITY(1,1),
                               ten_loai_san_pham NVARCHAR(255) NULL
);

CREATE TABLE San_Pham (
                          id INT PRIMARY KEY IDENTITY(1,1),
                          LSPID INT NULL,
                          TenSP NVARCHAR(255) NULL,
                          Gia MONEY,
                          quantity INT NULL,
                          mo_ta NVARCHAR(255) NULL,
                          images NVARCHAR(max),
                          FOREIGN KEY (LSPID) REFERENCES Loai_San_Pham(LSPID)
);

CREATE TABLE Hoa_Don (
                         MaHD INT PRIMARY KEY IDENTITY(1,1),
                         Ngay DATETIME NOT NULL,
                         TongTien FLOAT
);

CREATE TABLE chi_tiet_hoa_don (
                                  MaHDCT INT,
                                  MaHD INT,
                                  id INT,
                                  SoLuong INT,
                                  Gia DECIMAL(10, 2) NULL,
                                  FOREIGN KEY (MaHD) REFERENCES Hoa_Don(MaHD),
                                  FOREIGN KEY (id) REFERENCES San_Pham(id),
                                  PRIMARY KEY (MaHDCT)
);

SET IDENTITY_INSERT [dbo].[Account] ON

INSERT [dbo].[Account] ([id], [username], [password], [email]) VALUES (22, N'nhuthai', N'$2a$10$TvBF3qD3KZYnn.nMi/2VhOWpJe/mtNODJpczvMPxqBVf/vLXy1Q2W', N'lenhuthai2706@gmail.com')
INSERT [dbo].[Account] ([id], [username], [password], [email]) VALUES (23, N'nhuthai1', N'$2a$10$wVhyPDYrdXhO8i1GDarDs.XMmTUgoSPBrzwDAfg4.LfNf5bX59VL6', N'lenhuthai2706@gmail.com')
INSERT [dbo].[Account] ([id], [username], [password], [email]) VALUES (24, N'nhuthai5555', N'$2a$10$2vU6ao3dXlsyb2WbLWG8keSVfq6Db3kjiTuv5ATAKczgxEW5ysyaW', N'lenhuthai2706@gmail.com')
SET IDENTITY_INSERT [dbo].[Account] OFF


INSERT INTO Loai_San_Pham (ten_loai_san_pham) VALUES
    (N'Trà'),
    (N'Bánh');

INSERT INTO San_Pham (LSPID, TenSP, Gia, quantity, mo_ta, images) VALUES
(1, N'Trà Lài Mãng Cầu Đá Xay', 35000.00, 5, N'Trà sữa thơm ngon kết hợp với mãng cầu đen dai ngon', 'https://phuclong.com.vn/uploads/dish/063555c21c4206-trviliphclong.png'),
(1, N'Oreo Capuchino Đá Xay', 38000.00, 6, N'Trà sữa thơm ngon kết hợp với trân châu trắng mềm mịn', 'https://phuclong.com.vn/uploads/dish/72781119ecd681-sclaxaycnghnhnhnvespresso.png'),
(1, N'Trà sữa matcha', 40000.00, 7, N'Trà sữa thơm ngon vị matcha đặc trưng', 'https://phuclong.com.vn/uploads/dish/d1cd8bafdefe9d-matchalattephclong.png'),
(1, N'Capuchino Đá Xay', 35000.00, 5, N'Trà sữa thơm ngon kết hợp mát lạnh coffee', 'https://phuclong.com.vn/uploads/dish/d12b476cb8261d-cphcappuccinoxay.png'),
(1, N'Sữa Chua Xoài Đác Thơm', 38000.00, 6, N'Sữa thơm ngon kết hợp với xoài đác thơm', 'https://phuclong.com.vn/uploads/dish/65a7d028c2229d-sachuaxoicthmphclong.png'),
(1, N'Cà Phê Đen', 40000.00, 7, N'Cà phê đen hương vị đậm đà thơm đúng chất', 'https://phuclong.com.vn/uploads/dish/4521f4c77fc38a-cf67efb06d5aa504fc4b.png'),
(1, N'Trà Lucky', 42000.00, 8, N'Trà sữa thơm ngon vị hoa quả lạnh tươi mát', 'https://phuclong.com.vn/uploads/dish/3937476a64a213-trophclong.png'),
(1, N'Hồng Trà Chanh', 38000.00, 9, N'Trà hương tranh chua ngọt đậm đà nhất', 'https://phuclong.com.vn/uploads/dish/4d247cffb2c4d5-hngtrchanh.png'),
(2, N'Butter Chocolate Croissant', 15000.00, 10, N'Bánh có thêm các thanh chocolate', 'https://phuclong.com.vn/uploads/dish/a1c4d22a41ec76-banhphap_0003s_0000_chocobuttercroissant.jpg'),
(2, N'Tiramisu Mini', 12000.00, 8, N'món tráng miệng gồm nhiều lớp bánh ladyfinger', 'https://phuclong.com.vn/uploads/dish/dd626a9639b006-tiramisumini.png'),
(2, N'Green Tea Choco Cake', 10000.0000,10,N'Mát lạnh (matcha) và sự ngọt ngào của chocolate', N'https://phuclong.com.vn/uploads/dish/774b3f1fd9202e-greenteachocolatecake.png'),
(2, N'Bánh Mì Phúc Long (M)', 15000.0000,10,N'Đầy đủ hương vị truyền thống Việt Nam và phong cách hiện đại', N'https://phuclong.com.vn/uploads/dish/61b22d5643fc80-img_67711.png'),
(2, N'Passion Panna Cotta', 20000.0000,10,N'ón tráng miệng có kết cấu mềm mịn', N'https://phuclong.com.vn/uploads/dish/a9686c8f36a908-passionpannacotta.png');



SELECT * from San_Pham sp INNER JOIN Loai_San_Pham LSP on sp.LSPID = LSP.LSPID where LSP.ten_loai_san_pham=N'Bánh'
SELECT * from San_Pham sp INNER JOIN Loai_San_Pham LSP on sp.LSPID = LSP.LSPID where LSP.ten_loai_san_pham=N'Trà'
