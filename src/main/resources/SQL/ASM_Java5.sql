USE [master]
GO
/****** Object:  Database [ASM_Java5]    Script Date: 07/06/2024 8:24:42 CH ******/
CREATE DATABASE [ASM_Java5]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ASM_Java5', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\ASM_Java5.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'ASM_Java5_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\ASM_Java5_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [ASM_Java5] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ASM_Java5].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ASM_Java5] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ASM_Java5] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ASM_Java5] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ASM_Java5] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ASM_Java5] SET ARITHABORT OFF 
GO
ALTER DATABASE [ASM_Java5] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [ASM_Java5] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ASM_Java5] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ASM_Java5] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ASM_Java5] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ASM_Java5] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ASM_Java5] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ASM_Java5] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ASM_Java5] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ASM_Java5] SET  ENABLE_BROKER 
GO
ALTER DATABASE [ASM_Java5] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ASM_Java5] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ASM_Java5] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ASM_Java5] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ASM_Java5] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ASM_Java5] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ASM_Java5] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ASM_Java5] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ASM_Java5] SET  MULTI_USER 
GO
ALTER DATABASE [ASM_Java5] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ASM_Java5] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ASM_Java5] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ASM_Java5] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ASM_Java5] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [ASM_Java5] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [ASM_Java5] SET QUERY_STORE = ON
GO
ALTER DATABASE [ASM_Java5] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [ASM_Java5]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 07/06/2024 8:24:42 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](max) NULL,
	[email] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Banh]    Script Date: 07/06/2024 8:24:42 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Banh](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Ten] [nvarchar](100) NULL,
	[Gia] [money] NULL,
	[quantity] [int] NULL,
	[images] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 07/06/2024 8:24:42 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[MaHD] [int] NOT NULL,
	[ID] [int] NOT NULL,
	[SoLuong] [int] NULL,
	[DonGia] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC,
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 07/06/2024 8:24:42 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHD] [int] NOT NULL,
	[Ngay] [datetime] NULL,
	[TongTien] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TraSua]    Script Date: 07/06/2024 8:24:42 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TraSua](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Ten] [nvarchar](100) NULL,
	[Gia] [money] NULL,
	[mo_ta] [nvarchar](max) NULL,
	[quantity] [int] NULL,
	[images] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Account] ON 

INSERT [dbo].[Account] ([id], [username], [password], [email]) VALUES (22, N'nhuthai', N'$2a$10$TvBF3qD3KZYnn.nMi/2VhOWpJe/mtNODJpczvMPxqBVf/vLXy1Q2W', N'lenhuthai2706@gmail.com')
INSERT [dbo].[Account] ([id], [username], [password], [email]) VALUES (23, N'nhuthai1', N'$2a$10$wVhyPDYrdXhO8i1GDarDs.XMmTUgoSPBrzwDAfg4.LfNf5bX59VL6', N'lenhuthai2706@gmail.com')
INSERT [dbo].[Account] ([id], [username], [password], [email]) VALUES (24, N'nhuthai5555', N'$2a$10$2vU6ao3dXlsyb2WbLWG8keSVfq6Db3kjiTuv5ATAKczgxEW5ysyaW', N'lenhuthai2706@gmail.com')
SET IDENTITY_INSERT [dbo].[Account] OFF
GO
SET IDENTITY_INSERT [dbo].[Banh] ON 

INSERT [dbo].[Banh] ([ID], [Ten], [Gia], [quantity], [images]) VALUES (10, N'Tên sản phẩm 1', 10000.0000, 5, N'https://phuclong.com.vn/uploads/dish/774b3f1fd9202e-greenteachocolatecake.png')
INSERT [dbo].[Banh] ([ID], [Ten], [Gia], [quantity], [images]) VALUES (11, N'Tên sản phẩm 2', 15000.0000, 10, N'https://phuclong.com.vn/uploads/dish/61b22d5643fc80-img_67711.png')
INSERT [dbo].[Banh] ([ID], [Ten], [Gia], [quantity], [images]) VALUES (12, N'Tên sản phẩm 3', 20000.0000, 8, N'https://phuclong.com.vn/uploads/dish/a9686c8f36a908-passionpannacotta.png')
SET IDENTITY_INSERT [dbo].[Banh] OFF
GO
SET IDENTITY_INSERT [dbo].[TraSua] ON 

INSERT [dbo].[TraSua] ([ID], [Ten], [Gia], [mo_ta], [quantity], [images]) VALUES (25, N'Trà sữa trân châu đen', 35000.0000, N'Trà sữa thơm ngon kết hợp với trân châu đen dai ngon', 5, N'https://phuclong.com.vn/uploads/dish/65a7d028c2229d-sachuaxoicthmphclong.png')
INSERT [dbo].[TraSua] ([ID], [Ten], [Gia], [mo_ta], [quantity], [images]) VALUES (26, N'Trà sữa trân châu trắng', 38000.0000, N'Trà sữa thơm ngon kết hợp với trân châu trắng mềm mịn', 6, N'https://phuclong.com.vn/uploads/dish/4d247cffb2c4d5-hngtrchanh.png')
INSERT [dbo].[TraSua] ([ID], [Ten], [Gia], [mo_ta], [quantity], [images]) VALUES (27, N'Trà sữa matcha', 40000.0000, N'Trà sữa thơm ngon vị matcha đặc trưng', 7, N'https://phuclong.com.vn/uploads/dish/d1cd8bafdefe9d-matchalattephclong.png')
INSERT [dbo].[TraSua] ([ID], [Ten], [Gia], [mo_ta], [quantity], [images]) VALUES (28, N'Trà sữa hoa quả', 42000.0000, N'Trà sữa thơm ngon vị hoa quả tươi mát', 8, N'https://phuclong.com.vn/uploads/dish/a75db2931ab34c-hngtrsaphclongtrosaphclong.png')
INSERT [dbo].[TraSua] ([ID], [Ten], [Gia], [mo_ta], [quantity], [images]) VALUES (29, N'Trà sữa socola', 38000.0000, N'Trà sữa thơm ngon vị socola đậm đà', 9, N'https://phuclong.com.vn/uploads/dish/64bd44180be24c-sinhtchanh.png')
INSERT [dbo].[TraSua] ([ID], [Ten], [Gia], [mo_ta], [quantity], [images]) VALUES (30, N'Trà sữa hồng trà', 36000.0000, N'Trà sữa thơm ngon vị hồng trà truyền thống', 10, N'https://phuclong.com.vn/uploads/dish/5db8d7830383fe-trxanhxay.png')
INSERT [dbo].[TraSua] ([ID], [Ten], [Gia], [mo_ta], [quantity], [images]) VALUES (31, N'Trà sữa trái cây', 45000.0000, N'Trà sữa thơm ngon vị trái cây tươi ngon', 11, N'https://phuclong.com.vn/uploads/dish/72781119ecd681-sclaxaycnghnhnhnvespresso.png')
INSERT [dbo].[TraSua] ([ID], [Ten], [Gia], [mo_ta], [quantity], [images]) VALUES (32, N'Trà sữa mắc ca', 48000.0000, N'Trà sữa thơm ngon vị mắc ca thơm lừng', 12, N'https://phuclong.com.vn/uploads/dish/dae727e03e8092-daccam.png')
SET IDENTITY_INSERT [dbo].[TraSua] OFF
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD FOREIGN KEY([MaHD])
REFERENCES [dbo].[HoaDon] ([MaHD])
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD FOREIGN KEY([ID])
REFERENCES [dbo].[TraSua] ([ID])
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD FOREIGN KEY([ID])
REFERENCES [dbo].[Banh] ([ID])
GO
USE [master]
GO
ALTER DATABASE [ASM_Java5] SET  READ_WRITE 
GO
