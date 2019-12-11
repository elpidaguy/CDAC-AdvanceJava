<jsp:setProperty property="*" name="voter" />
<jsp:forward page="${sessionScope.voter.validateVoter()}.jsp" />
