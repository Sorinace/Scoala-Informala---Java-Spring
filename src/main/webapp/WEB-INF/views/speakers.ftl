<#include "./parts/header.ftl">

  <div class="container mt-4">
    <div class="row">
      <div class="col-sm-8">
        <article class="speakerslist maincontent">

        <#list speakers as speaker>
          <div class="mb-4">
            <h4 class="speakerslist-title">${speaker["title"]}</h4>
            <div class="speakerslist-name">with
              <a href="/speakers/${speaker["shortname"]}">${speaker["name"]}</a>
            </div>
            <div class="row speakerslist-info mt-2">
              <div class="col-sm-3">
                <a href="/speakers/${speaker["shortname"]}">
                  <img class="speakerslist-img rounded-circle img-fluid" src="/images/speakers/${speaker["shortname"]}_tn.jpg"
                    alt="Photo of ${speaker["name"]}">
                </a>
              </div>
              <div class="col-sm-9">
                ${speaker["summary"]}
              </div>
            </div>
          </div>
        </#list>

        </article>
      </div>
      <aside class="col-sm-4">
        <article class="sidebar">
          <h1 class="sidebar-title">Artwork on display</h1>
          <p class="sidebar-body">While you attend the conference, head over to our gallery where you can check out some
            of the work from our speakers.</p>
          <#include "./parts/allimg.ftl">
        </article>
      </aside>

    </div>
  </div>

<#include "./parts/footer.ftl">