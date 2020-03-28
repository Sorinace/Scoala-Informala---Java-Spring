<div class="pixgrid clearfix">
    <#assign x = 0>
       <#list artworks as picture>
              <img src="/images/artwork/${picture.getPicture()}" alt="Artwork ${x}">
              <#assign x++>
       </#list>
    </div>
