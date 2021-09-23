<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="d-sm-flex justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">공지</h1>
                    <a href="/notice/register" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">글쓰기</a>
                </div>


                <p class="mb-4"> </p>
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
                                        <td><a href="javascript:moveRead(${dto.nno})"> <c:out value="${dto.title}"></c:out></a></td>
                                        <td><c:out value="${dto.writer}"></c:out></td>
                                        <td><c:out value="${dto.content}"></c:out></td>
                                        <td><c:out value="${dto.regDate}"></c:out></td>
                                        <td><c:out value="${dto.modDate}"></c:out></td>
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
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-light border-0 small" placeholder="검색내용을 입력하세요."
                                               aria-label="Search" aria-describedby="basic-addon2" name="keyword" value="${pageRequestDTO.keyword}">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="submit">
                                                <i class="fas fa-search fa-sm"></i>
                                            </button>
                                        </div>
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

    </div>
    <!-- End of Content Wrapper -->
</div>
<!-- End of Page Wrapper -->







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