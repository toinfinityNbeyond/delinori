<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Tables</title>

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">


            </nav>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                <h1 class="h3 mb-2 text-gray-800">공지</h1>
                <p class="mb-4"> 딜리노리 공지사항 </p>
                </div>

                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">공지</h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>nno</th>
                                    <th>title</th>
                                    <th>writer</th>
                                    <th>content</th>
                                    <th>regDate</th>
                                    <th>modDate</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${dtoList}" var="dto">
                                    <tr>
                                        <td><c:out value="${dto.nno}"></c:out></td>
                                        <td><c:out value="${dto.title}"></c:out></td>
                                        <td><c:out value="${dto.writer}"></c:out></td>
                                        <td><c:out value="${dto.regDate}"></c:out></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>

                            <form action="/notice/list" method="get">
                                <input type="hidden" name="page" value="1"> <!--검색 시 결과가 1페이지부터 나오게 하려고 value값을 1 로 줬다.-->
                                <input type="hidden" name="size" value="${pageMaker.size}">
                                <div class="col-sm-3">
                                    <!-- select -->
                                    <div class="form-group">
                                        <label>Search</label>
                                        <select name="type" class="custom-select">
                                            <option value="">-------</option>
                                            <option value="T" ${pageRequestDTO.type == "T"?"selected" : ""}>제목</option>
                                            <option value="TC" ${pageRequestDTO.type == "TC"?"selected" : ""}>제목내용</option>
                                            <option value="C" ${pageRequestDTO.type == "C"?"selected" : ""}>내용</option>
                                            <option value="TCW" ${pageRequestDTO.type == "TCW"?"selected" : ""}>제목내용작성자</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-sm-9">
                                    <div class="input-group input-group-sm">
                                        <input type="text" class="form-control" name="keyword" value="${pageRequestDTO.keyword}">
                                        <span class="input-group-append"> <button type="submit" class="btn btn-info btn-flat">Go!</button></span>
                                    </div>
                                </div>
                            </form>  <!--버튼이 폼안에 있어야 작동을 해서 폼으로 감싸줬다.-->
                        </div>

                        <div class="card-footer clearfix">
                            <ul class="pagination pagination-sm m-0 float-right">
                                <c:if test="${pageMaker.prev}">
                                    <li class="page-item"><a class="page-link" href="javascript:movePage(${pageMaker.start -1})"> << </a></li>
                                </c:if>

                                <c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="num">
                                    <li class="page-item ${pageMaker.page == num?'active': ''}"><a class="page-link" href="javascript:movePage(${num})">${num}</a></li>
                                </c:forEach>   <!--1부터 10까지 돌아서 페이지번호 찍히게 forEach 선언-->
                                <!--c아웃 대신 a태그를  쓴 이유가 단순 클릭해서 페이지를 넘기기는 때문에, c 아웃은 공격 방어-> 단순처리가 그럴 일이 없어서 a태그 사용-->

                                <c:if test="${pageMaker.next}">
                                    <li class="page-item"><a class="page-link" href="javascript:movePage(${pageMaker.end + 1})"> >> </a></li>
                                </c:if>

                            </ul>
                        </div>
                    </div>
                </div>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; Your Website 2020</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="login.html">Logout</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="vendor/datatables/jquery.dataTables.min.js"></script>
<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

<!-- Page level custom scripts -->
<script src="js/demo/datatables-demo.js"></script>








<form id="actionForm" action="/notice/list" method="get">

    <input type="hidden" name="page" value="${pageMaker.page}">
    <input type="hidden" name="size" value="${pageMaker.size}">

    <c:if test="${pageRequestDTO.type != null}"> <!--검색 조건 있을 때만 URL에 나오게-->
        <input type="hidden" name="type" value= "${pageRequestDTO.type}">
        <input type="hidden" name="keyword" value= "${pageRequestDTO.keyword}"> <!--검색 조건과 키워드가 유지를 해주려고 사용-->
    </c:if>

</form>


<%@ include file="../includes/footer.jsp" %>




<script>

    const actionForm = document.querySelector("#actionForm")  // 아이디 값을 가져옴

    const result = '${result}'

    if(result && result !== ''){
        $('#modal-sm').modal('show')

        window.history.replaceState(null, '', '/notice/list');
    }


    function movePage(pageNum) {

        //클릭한 페이지 번호 값으로 바꾼다.
        actionForm.querySelector("input[name='page']") .setAttribute("value",pageNum)  // 페이지 엘리먼트
        // 페이지번호 누르면 해당 페이지로 이동.
        actionForm.submit()

        //#이랑 . 이 css의 셀렉터 기능
    }


    function moveRead(nno){
        // alert(bno)
        actionForm.setAttribute("action","/notice/read") // read 로 이동하도로
        actionForm.innerHTML += `<input type = 'hidden' name = 'nno' value = '\${nno}'>` // 단순 문자로 인식하게 \$로 작성
        actionForm.submit()


    }


</script>



</body>
</html>