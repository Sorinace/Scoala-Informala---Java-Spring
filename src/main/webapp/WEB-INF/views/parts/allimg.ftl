<div class="pixgrid clearfix">
    <#assign x = 0>
       <#list speakers as speaker>
           <#list speaker["artwork"] as picture>
              <img src="/images/artwork/${picture}" alt="Artwork ${x}">
              <#assign x++>
           </#list>
       </#list>
    </div>
