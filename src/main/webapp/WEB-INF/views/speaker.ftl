<#include "./parts/header.ftl">

  <div class="container mt-4">
    <div class="row">
      <div class="col-md-8">
        <article class="speakerslist maincontent">

          <h1 class="speakerslist-title">${artist["title"]}</h1>
          <div class="speakerslist-name">with
            <a href="/speakers/${artist["shortname"]}">${artist["name"]}</a>
          </div>
          <p class="speakerslist-info mt-2"> <a href="/speakers/${artist["shortname"]}">
            </a>
            <img class="speakerslist-img img-fluid" src="/images/speakers/${artist["shortname"]}.jpg"
              alt="Photo of ${artist["name"]}">
          </p>${artist["summary"]}</p>

        </article>
      </div>
      <aside class="col-md-4">
        <article class="sidebar">
          <h1 class="sidebar-title">Artwork on display</h1>
          <p class="sidebar-body">While you attend the conference, head over to our gallery where you can
            check out some of the work from our speakers.</p>
            <div class="pixgrid clearfix">
              <#list artist["artwork"] as picture>
                   <img src="/images/artwork/${picture}" alt="Artwork ${picture?index}">
              </#list>
            </div>
      </aside>
    </div>
  </div>

 <#include "./parts/footer.ftl">