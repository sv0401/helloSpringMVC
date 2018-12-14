<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr> 
			<td>년도</td>  
			<td>학기</td> 
			<td>이수 학점</td> 
			<td>상세보기</td> 
		</tr>
		<tr> 
			<td>${fs161.year}</td>  
			<td>${fs161.semester}</td> 
			<td>${fs161.totalGrade}</td> 
			<td><a href="/helloSpringMVC/semester?year=2016&semester=1">링크</a></td> 
		</tr>
		<tr> 
			<td>${fs162.year}</td>  
			<td>${fs162.semester}</td> 
			<td>${fs162.totalGrade}</td> 
			<td><a href="/helloSpringMVC/semester?year=2016&semester=2">링크</a></td> 
		</tr>
		<tr> 
			<td>${fs171.year}</td>  
			<td>${fs171.semester}</td> 
			<td>${fs171.totalGrade}</td> 
			<td><a href="/helloSpringMVC/semester?year=2017&semester=1">링크</a></td> 
		</tr>
		<tr> 
			<td>${fs172.year}</td>  
			<td>${fs172.semester}</td> 
			<td>${fs172.totalGrade}</td> 
			<td><a href="/helloSpringMVC/semester?year=2017&semester=2">링크</a></td> 
		</tr>
		<tr> 
			<td>${fs181.year}</td>  
			<td>${fs181.semester}</td> 
			<td>${fs181.totalGrade}</td> 
			<td><a href="/helloSpringMVC/semester?year=2018&semester=1">링크</a></td> 
		</tr>
		<tr> 
			<td>${fs182.year}</td>  
			<td>${fs182.semester}</td> 
			<td>${fs182.totalGrade}</td> 
			<td><a href="/helloSpringMVC/semester?year=2018&semester=2">링크</a></td> 
		</tr>
	</table>


</body>
</html>