<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
 
<head>
<title><ps:text name="usr.security.mngmt"/></title>
</head>
<script type="text/javascript"  src="${pageContext.request.contextPath}/common/js/tabs/TabbedPanel.js"></script>
<script type="text/javascript">
	var RTL_DIRECTION = "${isRTL}";
	
	$(document).ready(function() {
		intializeMainTabs("mainTabs",{url:jQuery.contextPath+"/path/loadScreen?",reloadAlert:'<ps:text name="Do you need to reload the tab contents of"/>',closeAlert:'<ps:text name="close"/>'});

	});
</script>

<body >


<div id="mainTabs" style="margin-top: 1em; visibility: hidden;">
	<ul></ul>
</div>
</body>
