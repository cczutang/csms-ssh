<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file = "../WEB-INF/view/header.jsp" %>
    <%@ include file = "../WEB-INF/view/left.jsp" %>
    <%@ include file = "../WEB-INF/view/footer.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>后台管理系统</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <script src="../js/jquery.js"></script>
    <script src="../js/jquery-1.8.3.js"></script>
    <script src="https://unpkg.com/echarts@3.5.3/dist/echarts.js" charset="UTF-8"></script>
    <script src="../js/jquery.mCustomScrollbar.concat.min.js"></script>
    
    <!-- fullcalendar日历插件需要资源 -->
    <link href='../css/calendar/fullcalendar.css' rel='stylesheet' />
	<link href='../css/calendar/fullcalendar.print.min.css' rel='stylesheet' media='print' />
	<script src='../js/calendar/moment.min.js'></script>
	<script src='../js/calendar/jquery.min.js'></script>
	<script src='../js/calendar/fullcalendar.js'></script>
</head>
<body>
    <section class="rt_wrap content mCustomScrollbar">
        <div class="rt_content">
         	
            <div id="barChart" style="width: 800px; height: 400px"></div>  
            <hr> 
            <div id='calendar'></div> 
        </div>
    </section>
</body>
<script type="text/javascript">  
    //图表  
    var psLineChar = echarts.init(document.getElementById('barChart')); 
    //查询  
    function loadDrugs() {  
        psLineChar.clear();  
        psLineChar.showLoading({text: '正在努力的读取数据中...'});  
        $.getJSON('${pageContext.request.contextPath}/barChartJson', function (data) {  
        	console.log(psLineChar);  
            console.log(data);  
            psLineChar.setOption(data, true);  
            psLineChar.hideLoading();  
        });  
    };
    loadDrugs(); 
    
    function calendar(){
    	$('#calendar').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			defaultDate: '2017-06-28',
			navLinks: true, // can click day/week names to navigate views
			selectable: true,
			selectHelper: true,
			select: function(start, end) {
				var title = prompt('Event Title:');
				var eventData;
				if (title) {
					eventData = {
						title: title,
						start: start,
						end: end
					};
					$('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
				}
				$('#calendar').fullCalendar('unselect');
			},
			editable: true,
			eventLimit: true, // allow "more" link when too many events
			events:[
				
			]
    	});
    };
    
    //载入图表  
    
    
    //载入日历
    calendar();
</script>
</html>