<#if feed.getVisible()>
    <a href="/publish/${feed.getId()}/false">Hide</a> |
 <#else>
    <a href="/publish/${feed.getId()}/true">Publish</a> |
</#if>
 <a href="/update/${feed.getId()}">Update</a> |
 <a href="/delete/${feed.getId()}">Delete</a> |

