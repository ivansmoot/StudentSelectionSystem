--专业表D，专业代码dno，专业名称dn 
create table D(dno char(3) primary key,dn char(15) unique not null) select * from S insert into D values('001','js')

--教师表T，教师号tno，姓名tn，性别tsex，入职年ty，密码tp，专业代码dno
create table T(tno char(9) primary key,tn char(8),tsex char(2) check(tsex in('男','女')),ty int check(ty between 2000 and 2018),
tp char(8),dno char(3) foreign key references D(dno))

--学生表S，学号sno，姓名sn，性别ssex，入学年sy，密码sp，专业代码dno
create table S(sno char(7) primary key,sn char(8),ssex char(2) check(ssex in('男','女')),sy int check(sy between 2000 and 2018),
sp char(8),dno char(3) foreign key references D(dno))

--课程表C，课程号cno，课程名cn，学分cs，学时cp，性质cc，专业代码dno ,人数 n,
create table C(cno char(12) primary key,cn char(30) not null,cs float check(cs between 0.5 and 10),cp int check(cp between 20 and 80),
cc int check(cc between 0 and 1) ,dno char(3) foreign key references D(dno),n int default 0) 

--授课关系表TC，教师号tno，课程号cno,学年sy,学期term
create table TC(tno char(9) foreign key references T(tno),cno char(12) foreign key references C(cno),sy int,term int not null,primary key(tno,cno))

--选课关系表SC，学号sno，课程号cno，成绩score，sy学年，学期term
create table SC(sno char(7) foreign key references S(sno),cno char(12) foreign key references C(cno),score float,primary key(sno,cno),sy int ,term int )

--教学计划表TP，学年sy,学期term,年级sy1,专业dn,课程号cno,学分cs,学时 cp,理论教学学时 cp1,实验/实践学时 cp2,上机学时 cp3,每周学时 cp4
create table TP(sy int not null ,term int not null,sy1 int, dno char(15) not null, cno char(12) foreign key references C(cno),
cs float check(cs between 0.5 and 10) not null ,cp int check(cp between 20 and 80 ) not null,cp1 int check(cp1 between 0 and 80),
cp2 int check(cp2 between 0 and 80),cp3 int check(cp3 between 0 and 80),cp4 int check(cp4 between 2 and 6) not null) 

---课表CTimetable,学年sy,学期term,年级sy1,专业dno,课程号cno,开始周week1,结束周week2，星期1weekday1,星期2weekday2,节数1section1,节数2section2
create table CTimetable(sy int not null,term int not null,sy1 int, dno char(15) not null,cno char(12)  foreign key references C(cno),
tno char(9) foreign key references T(tno),week1 char(12) ,week2 char(12),weekday1 char(9),weekday2 char(9),section1 char(9),section2 char(9)) 

--时间表 t_ime, 课程号cno，专业号dno(给哪个专业上的)，学年_year，学期term
create table t_ime(cno char(12),dno char(3),_year int,term int,primary key(cno,dno))

--管理员表
create table M(Username char(10) primary key,password char(10) not null,Name char(10) not null)
insert into M values('admin','password','name')
delete sc


--触发器TC_SC
go
create Trigger TC_SC   
on TC 
for insert 
as
begin
insert into SC(sno,cno,sy,term) select sno,inserted.cno,inserted.sy,term from S,inserted where S.dno='CS' 
end
go

--触发器TP_CT_insert
drop trigger TP_CT_insert
go
create Trigger TP_CT_insert
on TP
for insert 
as
begin
insert into CTimetable(sy,term,dno,cno) select sy,term,dno,cno from inserted where dno='CS';
end
go

--删除触发器TP_CT_delete
go
create Trigger TP_CT_delete
on TP
for delete
as 
begin
delete from CTimetable where sy in(select sy from deleted) and term in(select term from deleted) and dno in(select dno from deleted)
and cno in(select cno from deleted ) 
end
go

--查看所有触发器
drop trigger TC_SC
delete from TP
delete from CTimetable
delete from TC
select * from SC
select name from sysobjects where xtype='TR'
select * from TP
select * from CTimetable

	
	 
insert into D values('001','计算机')
insert into D values('002','广告')
insert into D values('003','市场营销')
insert into D values('004','城管')
insert into D values('005','集成')

insert into T values('000000001','教师1','男','2000','00000000','001')
insert into T values('000000002','教师2','男','2001','00000000','001')
insert into T values('000000003','教师3','女','2013','00000000','001')
insert into T values('000000004','教师4','女','2004','00000000','001')
insert into T values('000000005','教师5','女','2018','00000000','001')

insert into T values('000000006','教师6','男','2005','00000000','002')
insert into T values('000000007','教师7','男','2002','00000000','002')
insert into T values('000000008','教师8','女','2005','00000000','002')
insert into T values('000000009','教师9','女','2001','00000000','002')
insert into T values('000000010','教师10','女','2011','00000000','002')

insert into T values('000000011','教师11','男','2017','00000000','003')
insert into T values('000000012','教师12','男','2003','00000000','003')
insert into T values('000000013','教师13','女','2004','00000000','003')
insert into T values('000000014','教师14','女','2018','00000000','003')
insert into T values('000000015','教师15','女','2011','00000000','003')

insert into T values('000000016','教师16','男','2003','00000000','004')
insert into T values('000000017','教师17','男','2002','00000000','004')
insert into T values('000000018','教师18','女','2001','00000000','004')
insert into T values('000000019','教师19','女','2002','00000000','004')
insert into T values('000000020','教师20','女','2013','00000000','004')

insert into T values('000000021','教师21','男','2006','00000000','005')
insert into T values('000000022','教师22','男','2007','00000000','005')
insert into T values('000000023','教师23','女','2002','00000000','005')
insert into T values('000000024','教师24','女','2009','00000000','005')
insert into T values('000000025','教师25','女','2012','00000000','005')

insert into S values('0000001','学生1','男','2016','00000000','001')
insert into S values('0000002','学生2','男','2008','00000000','001')
insert into S values('0000003','学生3','女','2002','00000000','001')
insert into S values('0000004','学生4','女','2013','00000000','001')
insert into S values('0000005','学生5','女','2010','00000000','001')

insert into S values('0000006','学生6','男','2016','00000000','002')
insert into S values('0000007','学生7','男','2008','00000000','002')
insert into S values('0000008','学生8','女','2002','00000000','002')
insert into S values('0000009','学生9','女','2013','00000000','002')
insert into S values('0000010','学生10','女','2010','00000000','002')

insert into S values('0000011','学生11','男','2016','00000000','003')
insert into S values('0000012','学生12','男','2008','00000000','003')
insert into S values('0000013','学生13','女','2002','00000000','003')
insert into S values('0000014','学生14','女','2013','00000000','003')
insert into S values('0000015','学生15','女','2010','00000000','003')

insert into S values('0000016','学生16','男','2016','00000000','004')
insert into S values('0000017','学生17','男','2008','00000000','004')
insert into S values('0000018','学生18','女','2002','00000000','004')
insert into S values('0000019','学生19','女','2013','00000000','004')
insert into S values('0000020','学生20','女','2010','00000000','004')

insert into S values('0000021','学生21','男','2016','00000000','005')
insert into S values('0000022','学生22','男','2008','00000000','005')
insert into S values('0000023','学生23','女','2002','00000000','005')
insert into S values('0000024','学生24','女','2013','00000000','005')
insert into S values('0000025','学生25','女','2010','00000000','005')

insert into C values('000000000001','高等数学','5','48','1','001','0')
insert into C values('000000000002','C++','3','36','1','002','0')
insert into C values('000000000003','制图','1','25','1','003','0')
insert into C values('000000000004','大学语文','3','20','0','004','0')
insert into C values('000000000005','毛概','2','54','0','005','0')

insert into TC values('000000001','000000000001','2017','1')
insert into TC values('000000002','000000000001','2016','1')
insert into TC values('000000003','000000000001','2017','2')
insert into TC values('000000004','000000000001','2018','1')
insert into TC values('000000005','000000000001','2018','2')

insert into TC values('000000006','000000000002','2017','1')
insert into TC values('000000007','000000000002','2016','1')
insert into TC values('000000008','000000000002','2017','2')
insert into TC values('000000009','000000000002','2018','1')
insert into TC values('000000010','000000000002','2018','2')

insert into TC values('000000011','000000000003','2017','1')
insert into TC values('000000012','000000000003','2016','1')
insert into TC values('000000013','000000000003','2017','2')
insert into TC values('000000014','000000000003','2018','1')
insert into TC values('000000015','000000000003','2018','2')

insert into TC values('000000016','000000000004','2017','1')
insert into TC values('000000017','000000000004','2016','1')
insert into TC values('000000018','000000000004','2017','2')
insert into TC values('000000019','000000000004','2018','1')
insert into TC values('000000020','000000000004','2018','2')

insert into TC values('000000021','000000000005','2017','1')
insert into TC values('000000022','000000000005','2016','1')
insert into TC values('000000023','000000000005','2017','2')
insert into TC values('000000024','000000000005','2018','1')
insert into TC values('000000025','000000000005','2018','2')

insert into SC values('0000001','000000000001','80','2017','1') 
insert into SC values('0000001','000000000002','84','2016','1') 
insert into SC values('0000001','000000000003','58','2017','2') 
insert into SC values('0000001','000000000005','70','2018','1') 

insert into t_ime values('000000000001','002','2017','1')
insert into t_ime values('000000000002','001','2018','1')
insert into t_ime values('000000000003','003','2017','2')
insert into t_ime values('000000000004','004','2016','1')
insert into t_ime values('000000000005','005','2017','1')

insert into SC values('0000006','000000000005',79,'2017','1')
insert into SC values('0000006','000000000001',100,'2017','1')

insert into SC values('0000010','000000000001',80,'2017','1')
insert into SC values('0000010','000000000005',88,'2017','1')





