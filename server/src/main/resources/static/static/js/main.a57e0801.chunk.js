(this.webpackJsonpclient=this.webpackJsonpclient||[]).push([[0],{47:function(e,t,n){},71:function(e,t,n){"use strict";n.r(t);var s=n(0),a=n(1),c=n.n(a),r=n(21),i=n.n(r),o=(n(47),n(5)),u=n.n(o),l=n(3),d=n(16),j=n(39),p=n(40),b=n(41),m="SET_ALERT",h="REMOVE_ALERT",f="LOAD_USER",x="RESET_AUTH",O="SET_POSTS",v="SET_POST",g="POST_ERROR",N="RESET_POST",k="SET_COMMENTS",y=[],w={isAuthenticated:!1,user:null},A=n(9),S={posts:[],post:null,loadedPosts:!1,loadedPost:!1},C={comments:[],loadedComments:!1},P=Object(d.combineReducers)({alert:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:y,t=arguments.length>1?arguments[1]:void 0,n=t.type,s=t.payload;switch(n){case m:return[].concat(Object(b.a)(e),[s]);case h:return e.filter((function(e){return e.id!==s.id}));default:return e}},auth:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:w,t=arguments.length>1?arguments[1]:void 0,n=t.type,s=t.payload;switch(n){case f:return{isAuthenticated:!0,user:s};case x:return w;default:return e}},post:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:S,t=arguments.length>1?arguments[1]:void 0,n=t.type,s=t.payload;switch(n){case O:return Object(A.a)(Object(A.a)({},e),{},{posts:s,loadedPosts:!0});case v:return Object(A.a)(Object(A.a)({},e),{},{post:s,loadedPost:!0});case g:return Object(A.a)(Object(A.a)({},e),{},{post:null,loadedPost:!0});case N:return S;default:return e}},comment:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:C,t=arguments.length>1?arguments[1]:void 0,n=t.type,s=t.payload;switch(n){case k:return{comments:s,loadedComments:!0};default:return e}}}),E=Object(d.createStore)(P,{},Object(j.composeWithDevTools)(Object(d.applyMiddleware)(p.a))),I=n(2),T=n.n(I),D=n(6),F=n(73),_=function(e,t){var n=arguments.length>2&&void 0!==arguments[2]?arguments[2]:2e3;return function(s){var a=Object(F.a)();s({type:m,payload:{msg:e,alertType:t,id:a}}),setTimeout((function(){s({type:h,payload:{msg:e,alertType:t,id:a}})}),n)}},R=function(e){return function(){var t=Object(D.a)(T.a.mark((function t(n){var s;return T.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:if(e.response&&e.response.data&&e.response.data.errors){t.next=3;break}return console.error(e),t.abrupt("return");case 3:if(!(s=e.response.data.errors)||"Token is not valid"!==s[0].msg){t.next=9;break}return n(_("Session expired","danger")),n(L()),t.abrupt("return");case 9:s.forEach((function(e){return n(_(e.msg,"danger"))}));case 11:case"end":return t.stop()}}),t)})));return function(e){return t.apply(this,arguments)}}()},L=function(){return function(){var e=Object(D.a)(T.a.mark((function e(t){return T.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:localStorage.removeItem("token"),delete u.a.defaults.headers.common["x-auth-token"],t({type:x});case 3:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}()},M=function(){return function(){var e=Object(D.a)(T.a.mark((function e(t){var n;return T.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,u.a.get("/api/users");case 3:n=e.sent,t({type:f,payload:n.data}),e.next=10;break;case 7:e.prev=7,e.t0=e.catch(0),t(R(e.t0));case 10:case 11:case"end":return e.stop()}}),e,null,[[0,7]])})));return function(t){return e.apply(this,arguments)}}()},U=n(8),W=n(7),Y={logout:L},B=Object(l.b)((function(e){return{isAuthenticated:e.auth.isAuthenticated}}),Y)((function(e){var t=e.logout,n=e.isAuthenticated,c=Object(s.jsxs)(a.Fragment,{children:[Object(s.jsx)("li",{children:Object(s.jsxs)(U.b,{to:"/edit-profile",children:[Object(s.jsx)("i",{className:"fas fa-user"}),Object(s.jsx)("span",{className:"hide-mobile",children:" Profile"})]})}),Object(s.jsx)("li",{children:Object(s.jsxs)(U.b,{onClick:function(e){return t()},to:"/",children:[Object(s.jsx)("i",{className:"fas fa-sign-out-alt"}),Object(s.jsx)("span",{className:"hide-mobile",children:" Logout"})]})})]}),r=Object(s.jsxs)(a.Fragment,{children:[Object(s.jsx)("li",{children:Object(s.jsxs)(U.b,{to:"/register",children:[Object(s.jsx)("i",{className:"fas fa-plus"}),Object(s.jsx)("span",{className:"hide-mobile",children:" Register"})]})}),Object(s.jsx)("li",{children:Object(s.jsxs)(U.b,{to:"/login",children:[Object(s.jsx)("i",{className:"fas fa-sign-in-alt"}),Object(s.jsx)("span",{className:"hide-mobile",children:" Login"})]})})]});return Object(s.jsxs)("nav",{className:"navbar bg-dark",children:[Object(s.jsx)("h1",{children:Object(s.jsxs)(U.b,{to:"/",children:[Object(s.jsx)("i",{className:"fas fa-file-code"}),Object(s.jsx)("span",{className:"hide-mobile",children:" DevBoard"})]})}),Object(s.jsxs)("ul",{children:[Object(s.jsx)("li",{children:Object(s.jsxs)(U.b,{to:"/posts",children:[Object(s.jsx)("i",{className:"fas fa-comment-alt"}),Object(s.jsx)("span",{className:"hide-mobile",children:" Posts"})]})}),n?c:r]})]})})),z=Object(l.b)((function(e){return{alerts:e.alert}}))((function(e){var t=e.alerts;return Object(s.jsx)(a.Fragment,{children:t.map((function(e){return Object(s.jsx)("div",{className:"alert bg-".concat(e.alertType),children:e.msg},e.id)}))})})),J=function(){return Object(s.jsxs)("footer",{className:"footer hide-mobile",children:[Object(s.jsxs)("div",{className:"item",children:[Object(s.jsx)("span",{children:"Author: Vincent Yang"}),Object(s.jsxs)("p",{className:"footer-links",children:[Object(s.jsx)("a",{href:"https://vincent-yang.com",children:"Personal Website"}),Object(s.jsx)("span",{children:" | "}),Object(s.jsx)("a",{href:"https://github.com/Yangv19",children:"Github"})]})]}),Object(s.jsxs)("div",{className:"item",children:[Object(s.jsxs)("div",{children:[Object(s.jsx)("i",{className:"fa fa-phone"}),Object(s.jsx)("span",{children:" 647-636-3461"})]}),Object(s.jsxs)("div",{children:[Object(s.jsx)("i",{className:"fa fa-envelope"}),Object(s.jsx)("span",{children:" v6yang@uwaterloo.ca"})]})]})]})},V=Object(l.b)((function(e){return{isAuthenticated:e.auth.isAuthenticated}}))((function(e){var t=e.isAuthenticated,n=Object(s.jsxs)("div",{children:[Object(s.jsx)(U.b,{to:"/register",className:"btn light bg-primary",children:"Sign Up"}),Object(s.jsx)(U.b,{to:"/login",className:"btn primary bg-light",children:"Login"})]});return Object(s.jsxs)(a.Fragment,{children:[Object(s.jsx)("section",{className:"landing",children:Object(s.jsx)("div",{className:"dark-overlay",children:Object(s.jsxs)("div",{className:"landing-inner",children:[Object(s.jsx)(z,{}),Object(s.jsx)("h1",{className:"x-large",children:"Developer Board"}),Object(s.jsx)("p",{className:"lead",children:"Start sharing issues, having discussions, and working collaboratively now"}),!t&&n]})})}),Object(s.jsx)(J,{})]})})),G=n(18),H=n(14),q={setAlert:_,register:function(e){return function(){var t=Object(D.a)(T.a.mark((function t(n){var s;return T.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.prev=0,t.next=3,u.a.post("/api/users/register",e);case 3:s=t.sent,localStorage.setItem("token",s.data.token),u.a.defaults.headers.common["x-auth-token"]=localStorage.token,n(M()),t.next=12;break;case 9:t.prev=9,t.t0=t.catch(0),n(R(t.t0));case 12:case 13:case"end":return t.stop()}}),t,null,[[0,9]])})));return function(e){return t.apply(this,arguments)}}()}},K=Object(l.b)((function(e){return{isAuthenticated:e.auth.isAuthenticated}}),q)((function(e){var t=e.setAlert,n=e.register,c=e.isAuthenticated,r=e.history,i=Object(a.useState)({username:"",email:"",password:"",password2:""}),o=Object(H.a)(i,2),u=o[0],l=o[1];Object(a.useEffect)((function(){c&&r.push("/")}),[c,r]);var d=u.username,j=u.email,p=u.password,b=u.password2,m=function(e){return l(Object(A.a)(Object(A.a)({},u),{},Object(G.a)({},e.target.name,e.target.value)))};return Object(s.jsxs)(a.Fragment,{children:[Object(s.jsxs)("section",{className:"container",children:[Object(s.jsx)("h1",{className:"large primary",children:"Sign Up"}),Object(s.jsxs)("p",{className:"lead",children:[Object(s.jsx)("i",{className:"fas fa-user"}),Object(s.jsx)("span",{className:"hide-mobile",children:" Create Your Account"})]}),Object(s.jsxs)("form",{className:"form",onSubmit:function(e){return function(e){e.preventDefault(),p!==b?t("Password do not match","danger"):n({username:d,email:j,password:p})}(e)},children:[Object(s.jsx)("div",{className:"form-group",children:Object(s.jsx)("input",{type:"text",placeholder:"Username",name:"username",value:d,onChange:function(e){return m(e)}})}),Object(s.jsx)("div",{className:"form-group",children:Object(s.jsx)("input",{type:"text",placeholder:"Email Address",name:"email",value:j,onChange:function(e){return m(e)}})}),Object(s.jsx)("div",{className:"form-group",children:Object(s.jsx)("input",{type:"password",placeholder:"Password",name:"password",value:p,onChange:function(e){return m(e)}})}),Object(s.jsx)("div",{className:"form-group",children:Object(s.jsx)("input",{type:"password",placeholder:"Confirm Password",name:"password2",value:b,onChange:function(e){return m(e)}})}),Object(s.jsx)("input",{type:"submit",className:"btn light bg-primary",value:"Register"})]}),Object(s.jsxs)("div",{className:"my-1",children:[Object(s.jsx)("p",{children:"Already have an account?"}),Object(s.jsx)(U.b,{to:"/login",children:"Sign In"})]})]}),Object(s.jsx)(J,{})]})})),Q={login:function(e){return function(){var t=Object(D.a)(T.a.mark((function t(n){var s;return T.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.prev=0,t.next=3,u.a.post("/api/users/login",e);case 3:s=t.sent,localStorage.setItem("token",s.data.token),u.a.defaults.headers.common["x-auth-token"]=localStorage.token,n(M()),t.next=12;break;case 9:t.prev=9,t.t0=t.catch(0),n(R(t.t0));case 12:case 13:case"end":return t.stop()}}),t,null,[[0,9]])})));return function(e){return t.apply(this,arguments)}}()}},X=Object(l.b)((function(e){return{isAuthenticated:e.auth.isAuthenticated}}),Q)((function(e){var t=e.login,n=e.isAuthenticated,c=e.history,r=Object(a.useState)({email:"",password:""}),i=Object(H.a)(r,2),o=i[0],u=i[1];Object(a.useEffect)((function(){n&&c.push("/")}),[n,c]);var l=o.email,d=o.password,j=function(e){return u(Object(A.a)(Object(A.a)({},o),{},Object(G.a)({},e.target.name,e.target.value)))};return Object(s.jsxs)(a.Fragment,{children:[Object(s.jsxs)("section",{className:"container",children:[Object(s.jsx)("h1",{className:"large primary",children:"Sign In"}),Object(s.jsxs)("p",{className:"lead",children:[Object(s.jsx)("i",{className:"fas fa-user"}),Object(s.jsx)("span",{className:"hide-mobile",children:" Sign Into Your Account"})]}),Object(s.jsxs)("form",{className:"form",onSubmit:function(e){return function(e){e.preventDefault(),t(o)}(e)},children:[Object(s.jsx)("div",{className:"form-group",children:Object(s.jsx)("input",{type:"text",placeholder:"Email Address",name:"email",value:l,onChange:function(e){return j(e)}})}),Object(s.jsx)("div",{className:"form-group",children:Object(s.jsx)("input",{type:"password",placeholder:"Password",name:"password",value:d,onChange:function(e){return j(e)}})}),Object(s.jsx)("input",{type:"submit",className:"btn light bg-primary",value:"Login"})]}),Object(s.jsxs)("div",{className:"my-1",children:[Object(s.jsx)("p",{children:'Don"t have an account?'}),Object(s.jsx)(U.b,{to:"/register",children:"Sign Up"})]})]}),Object(s.jsx)(J,{})]})})),Z=function(){return function(){var e=Object(D.a)(T.a.mark((function e(t){var n;return T.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,u.a.get("/api/posts");case 3:n=e.sent,t({type:O,payload:n.data}),e.next=10;break;case 7:e.prev=7,e.t0=e.catch(0),t(R(e.t0));case 10:case 11:case"end":return e.stop()}}),e,null,[[0,7]])})));return function(t){return e.apply(this,arguments)}}()},$=n.p+"static/media/spinner.f30ae0f0.gif",ee=function(){return Object(s.jsx)("img",{src:$,alt:"",className:"spinner"})},te={addPost:function(e){return function(){var t=Object(D.a)(T.a.mark((function t(n){return T.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.prev=0,t.next=3,u.a.post("/api/posts",e);case 3:n(_("Post Created","success")),n(Z()),t.next=10;break;case 7:t.prev=7,t.t0=t.catch(0),n(R(t.t0));case 10:case 11:case"end":return t.stop()}}),t,null,[[0,7]])})));return function(e){return t.apply(this,arguments)}}()}},ne=Object(l.b)(null,te)((function(e){var t=e.addPost,n=Object(a.useState)(""),c=Object(H.a)(n,2),r=c[0],i=c[1];return Object(s.jsxs)(a.Fragment,{children:[Object(s.jsx)("div",{className:"bg-primary light p",children:Object(s.jsx)("h3",{children:"Say Something..."})}),Object(s.jsxs)("form",{className:"form my-1",onSubmit:function(e){return function(e){e.preventDefault(),t({text:r}),i("")}(e)},children:[Object(s.jsx)("textarea",{cols:30,rows:5,placeholder:"Create a post",value:r,onChange:function(e){return function(e){return i(e.target.value)}(e)}}),Object(s.jsx)("input",{type:"submit",className:"btn bg-dark my-1",value:"Submit"})]})]})})),se={addLike:function(e){return function(){var t=Object(D.a)(T.a.mark((function t(n){return T.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.prev=0,t.next=3,u.a.patch("/api/posts/likes/".concat(e));case 3:n(Z()),t.next=9;break;case 6:t.prev=6,t.t0=t.catch(0),n(R(t.t0));case 9:case 10:case"end":return t.stop()}}),t,null,[[0,6]])})));return function(e){return t.apply(this,arguments)}}()},addDislike:function(e){return function(){var t=Object(D.a)(T.a.mark((function t(n){return T.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.prev=0,t.next=3,u.a.patch("/api/posts/dislikes/".concat(e));case 3:n(Z()),t.next=9;break;case 6:t.prev=6,t.t0=t.catch(0),n(R(t.t0));case 9:case 10:case"end":return t.stop()}}),t,null,[[0,6]])})));return function(e){return t.apply(this,arguments)}}()},deletePost:function(e){return function(){var t=Object(D.a)(T.a.mark((function t(n){return T.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.prev=0,t.next=3,u.a.delete("/api/posts/".concat(e));case 3:n(_("Post Removed","success")),n(Z()),t.next=10;break;case 7:t.prev=7,t.t0=t.catch(0),n(R(t.t0));case 10:case 11:case"end":return t.stop()}}),t,null,[[0,7]])})));return function(e){return t.apply(this,arguments)}}()},removeLike:function(e){return function(){var t=Object(D.a)(T.a.mark((function t(n){return T.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.prev=0,t.next=3,u.a.delete("/api/posts/likes/".concat(e));case 3:n(Z()),t.next=9;break;case 6:t.prev=6,t.t0=t.catch(0),n(R(t.t0));case 9:case 10:case"end":return t.stop()}}),t,null,[[0,6]])})));return function(e){return t.apply(this,arguments)}}()},removeDislike:function(e){return function(){var t=Object(D.a)(T.a.mark((function t(n){return T.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.prev=0,t.next=3,u.a.delete("/api/posts/dislikes/".concat(e));case 3:n(Z()),t.next=9;break;case 6:t.prev=6,t.t0=t.catch(0),n(R(t.t0));case 9:case 10:case"end":return t.stop()}}),t,null,[[0,6]])})));return function(e){return t.apply(this,arguments)}}()}},ae=Object(l.b)((function(e){return{auth:e.auth}}),se),ce=function(e){var t=e.addLike,n=e.addDislike,c=e.deletePost,r=e.removeLike,i=e.removeDislike,o=e.auth,u=e.post,l=e.showActions,d=Object(a.useState)({liked:!1,disliked:!1}),j=Object(H.a)(d,2),p=j[0],b=j[1];Object(a.useEffect)((function(){o.isAuthenticated&&(u.likes.find((function(e){return e.user===o.user._id}))&&u.dislikes.find((function(e){return e.user===o.user._id}))?b({disliked:!0,liked:!0}):u.likes.find((function(e){return e.user===o.user._id}))?b({disliked:!1,liked:!0}):u.dislikes.find((function(e){return e.user===o.user._id}))&&b({disliked:!0,liked:!1}))}),[u,o]);return Object(s.jsxs)("div",{className:"post p-1",children:[Object(s.jsxs)("div",{className:"post-first",children:[Object(s.jsx)("img",{className:"round-img hide-mobile",src:"data:image/png;base64, ".concat(u.user.avatar),alt:""}),Object(s.jsx)("h4",{children:u.user.username})]}),Object(s.jsxs)("div",{children:[Object(s.jsx)("p",{className:"my-1",children:u.text}),Object(s.jsxs)("p",{className:"post-date",children:["Posted on ",u.date.slice(0,10)]}),l&&Object(s.jsxs)(a.Fragment,{children:[Object(s.jsxs)("button",{onClick:function(e){o.isAuthenticated&&(p.liked?r(u.postId):t(u.postId),b(Object(A.a)(Object(A.a)({},p),{},{liked:!p.liked})))},className:"btn bg-light primary",children:[Object(s.jsx)("i",{className:"fas fa-thumbs-up"}),u.likes.length>0&&Object(s.jsxs)("span",{className:"comment-count",children:[" ",u.likes.length]})]}),Object(s.jsxs)("button",{onClick:function(e){o.isAuthenticated&&(p.disliked?i(u.postId):n(u.postId),b(Object(A.a)(Object(A.a)({},p),{},{disliked:!p.disliked})))},className:"btn bg-light primary",children:[Object(s.jsx)("i",{className:"fas fa-thumbs-down"}),u.dislikes.length>0&&Object(s.jsxs)("span",{className:"comment-count",children:[" ",u.dislikes.length]})]}),Object(s.jsxs)(U.b,{to:"/posts/".concat(u.postId),className:"btn bg-primary light",children:[Object(s.jsx)("i",{className:"fas fa-comment"}),Object(s.jsx)("span",{className:"hide-mobile",children:" Discussion"})]}),o.isAuthenticated&&u.user._id===o.user._id&&Object(s.jsx)("button",{onClick:function(e){return c(u.postId)},className:"btn bg-danger",children:Object(s.jsx)("i",{className:"fas fa-times"})})]})]})]})};ce.defaultProps={showActions:!0};var re=ae(ce),ie={getPosts:Z},oe=Object(l.b)((function(e){return{post:e.post,isAuthenticated:e.auth.isAuthenticated}}),ie)((function(e){var t=e.getPosts,n=e.post,c=e.isAuthenticated;return Object(a.useEffect)((function(){t()}),[t]),n.loadedPosts?Object(s.jsx)(a.Fragment,{children:Object(s.jsxs)("section",{className:"container",children:[Object(s.jsx)("h1",{className:"large primary",children:"Posts"}),Object(s.jsx)("p",{className:"lead",children:Object(s.jsx)("i",{className:"fas fa-user hide-mobile",children:"Welcome to the Community"})}),c&&Object(s.jsx)(ne,{}),Object(s.jsx)("div",{children:n.posts.map((function(e){return Object(s.jsx)(re,{post:e},e.postId)}))})]})}):Object(s.jsx)(ee,{})})),ue=function(e){return function(){var t=Object(D.a)(T.a.mark((function t(n){var s;return T.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.prev=0,t.next=3,u.a.get("/api/posts/comments/".concat(e));case 3:s=t.sent,n({type:k,payload:s.data}),t.next=10;break;case 7:t.prev=7,t.t0=t.catch(0),n(R(t.t0));case 10:case 11:case"end":return t.stop()}}),t,null,[[0,7]])})));return function(e){return t.apply(this,arguments)}}()},le={deleteComment:function(e,t){return function(){var n=Object(D.a)(T.a.mark((function n(s){return T.a.wrap((function(n){for(;;)switch(n.prev=n.next){case 0:return n.prev=0,n.next=3,u.a.delete("/api/posts/comments/".concat(e,"/").concat(t));case 3:s(_("Comment removed","success")),s(ue(e)),n.next=10;break;case 7:n.prev=7,n.t0=n.catch(0),s(R(n.t0));case 10:case 11:case"end":return n.stop()}}),n,null,[[0,7]])})));return function(e){return n.apply(this,arguments)}}()}},de=Object(l.b)((function(e){return{auth:e.auth}}),le)((function(e){var t=e.deleteComment,n=e.postId,a=e.comment,c=e.auth;return Object(s.jsxs)("div",{className:"post p-1",children:[Object(s.jsxs)("div",{className:"post-first",children:[Object(s.jsx)("img",{className:"round-img hide-mobile",src:"data:image/png;base64, ".concat(a.user.avatar),alt:""}),Object(s.jsx)("h4",{children:a.user.username})]}),Object(s.jsxs)("div",{children:[Object(s.jsx)("p",{className:"my-1",children:a.text}),Object(s.jsx)("p",{className:"post-date",children:a.date.slice(0,10)}),c.isAuthenticated&&a.user.userId===c.user.userId&&Object(s.jsx)("button",{onClick:function(e){return t(n,a.commentId)},className:"btn bg-danger",children:Object(s.jsx)("i",{className:"fas fa-times"})})]})]})})),je={addComment:function(e,t){return function(){var n=Object(D.a)(T.a.mark((function n(s){return T.a.wrap((function(n){for(;;)switch(n.prev=n.next){case 0:return n.prev=0,n.next=3,u.a.post("/api/posts/comments/".concat(e),t);case 3:s(_("Comment added","success")),s(ue(e)),n.next=10;break;case 7:n.prev=7,n.t0=n.catch(0),s(R(n.t0));case 10:case 11:case"end":return n.stop()}}),n,null,[[0,7]])})));return function(e){return n.apply(this,arguments)}}()}},pe=Object(l.b)(null,je)((function(e){var t=e.addComment,n=e.postId,c=Object(a.useState)(""),r=Object(H.a)(c,2),i=r[0],o=r[1];return Object(s.jsx)(a.Fragment,{children:Object(s.jsxs)("form",{className:"form my-1",onSubmit:function(e){return function(e){e.preventDefault(),t(n,{text:i}),o("")}(e)},children:[Object(s.jsx)("textarea",{name:"text",cols:30,rows:5,placeholder:"Leave a comment",value:i,onChange:function(e){return function(e){return o(e.target.value)}(e)}}),Object(s.jsx)("input",{type:"submit",className:"btn bg-dark my-1",value:"Submit"})]})})})),be={getPost:function(e){return function(){var t=Object(D.a)(T.a.mark((function t(n){var s;return T.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.prev=0,t.next=3,u.a.get("/api/posts/".concat(e));case 3:s=t.sent,n({type:v,payload:s.data}),t.next=11;break;case 7:t.prev=7,t.t0=t.catch(0),n(R(t.t0)),n({type:g});case 11:case"end":return t.stop()}}),t,null,[[0,7]])})));return function(e){return t.apply(this,arguments)}}()},resetPost:function(){return function(e){e({type:N})}},getComments:ue},me=Object(l.b)((function(e){return{post:e.post,isAuthenticated:e.auth.isAuthenticated,comment:e.comment}}),be)((function(e){var t=e.getPost,n=e.resetPost,c=e.getComments,r=e.post,i=e.comment,o=e.match,u=e.isAuthenticated,l=e.history;return Object(a.useEffect)((function(){t(o.params.id)}),[t,o]),Object(a.useEffect)((function(){r.loadedPost&&null===r.post&&(n(),l.push("/NotFound"))}),[r,l,n]),Object(a.useEffect)((function(){c(o.params.id)}),[c,o]),null===r.post?Object(s.jsx)(ee,{}):Object(s.jsx)(a.Fragment,{children:Object(s.jsxs)("section",{className:"container",children:[Object(s.jsx)(re,{post:r.post,showActions:!1}),u&&Object(s.jsx)(pe,{postId:r.post.postId}),Object(s.jsx)("div",{className:"bg-primary p light my-1",children:Object(s.jsx)("h3",{children:"Comments"})}),i.loadedComments?i.comments.map((function(e){return Object(s.jsx)(de,{comment:e,postId:r.post.postId},e.commentId)})):null]})})})),he={deleteAccount:function(){return function(){var e=Object(D.a)(T.a.mark((function e(t){return T.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,u.a.delete("/api/users");case 3:t(_("Account deleted","danger")),t(L()),e.next=10;break;case 7:e.prev=7,e.t0=e.catch(0),t(R(e.t0));case 10:case 11:case"end":return e.stop()}}),e,null,[[0,7]])})));return function(t){return e.apply(this,arguments)}}()},updateAccount:function(e){return function(){var t=Object(D.a)(T.a.mark((function t(n){var s;return T.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.prev=0,(s=new FormData).append("img",e),t.next=5,u.a.patch("/api/users",s);case 5:n(_("Image Added","success")),n(M()),t.next=12;break;case 9:t.prev=9,t.t0=t.catch(0),n(R(t.t0));case 12:case 13:case"end":return t.stop()}}),t,null,[[0,9]])})));return function(e){return t.apply(this,arguments)}}()}},fe=Object(l.b)((function(e){return{user:e.auth.user}}),he)((function(e){var t=e.deleteAccount,n=e.updateAccount,c=e.history,r=e.user,i=Object(a.useState)(null),o=Object(H.a)(i,2),u=o[0],l=o[1];return Object(s.jsxs)(a.Fragment,{children:[Object(s.jsxs)("section",{className:"container",children:[Object(s.jsx)("h1",{className:"large primary",children:"Dashboard"}),Object(s.jsx)("p",{className:"lead",children:Object(s.jsxs)("i",{className:"fas fa-user",children:["Welcome ",r.username]})}),Object(s.jsx)("img",{className:"round-img",src:"data:image/png;base64, ".concat(r.avatar),alt:""}),Object(s.jsxs)("div",{children:[Object(s.jsxs)("button",{className:"btn bg-danger w-15",onClick:function(e){t(),c.push("/")},children:[Object(s.jsx)("i",{className:"fas fa-user-minus"})," Delete My Account"]}),Object(s.jsxs)("form",{className:"my-1",onSubmit:function(e){return function(e){e.preventDefault(),n(u)}(e)},children:[Object(s.jsx)("input",{className:"btn bg-success w-15",type:"file",name:"img",onChange:function(e){return function(e){return l(e.target.files[0])}(e)}}),Object(s.jsx)("div",{className:"my-1",children:Object(s.jsx)("input",{className:"btn bg-success w-15",type:"submit",value:"Change profile"})})]})]})]}),Object(s.jsx)(J,{})]})})),xe=function(){return Object(s.jsxs)(a.Fragment,{children:[Object(s.jsxs)("section",{className:"container full",children:[Object(s.jsxs)("h1",{className:"large text-primary",children:[Object(s.jsx)("i",{className:"fas fa-exclamation-triangle"}),Object(s.jsx)("span",{children:" 404 Page Not Found"})]}),Object(s.jsx)("p",{className:"lead",children:"Sorry this page does not exist"})]}),Object(s.jsx)(J,{})]})},Oe=function(){return Object(s.jsxs)(W.c,{children:[Object(s.jsx)(W.a,{exact:!0,path:"/edit-profile",component:fe}),Object(s.jsx)(W.a,{exact:!0,path:"/*",component:xe})]})},ve=function(){return Object(s.jsxs)(a.Fragment,{children:[Object(s.jsxs)("section",{className:"container full",children:[Object(s.jsxs)("h1",{className:"large text-primary",children:[Object(s.jsx)("i",{className:"fas fa-skull-crossbones"}),Object(s.jsx)("span",{children:" 401 Not Authorized"})]}),Object(s.jsx)("p",{className:"lead",children:"Sorry you are not authorized to view this page"})]}),Object(s.jsx)(J,{})]})},ge=function(){return Object(s.jsxs)(W.c,{children:[Object(s.jsx)(W.a,{exact:!0,path:"/edit-profile",component:ve}),Object(s.jsx)(W.a,{exact:!0,path:"/*",component:xe})]})},Ne=Object(l.b)((function(e){return{isAuthenticated:e.auth.isAuthenticated}}))((function(e){var t=e.isAuthenticated;return Object(s.jsxs)(a.Fragment,{children:[Object(s.jsx)(z,{}),Object(s.jsxs)(W.c,{children:[Object(s.jsx)(W.a,{exact:!0,path:"/register",component:K}),Object(s.jsx)(W.a,{exact:!0,path:"/login",component:X}),Object(s.jsx)(W.a,{exact:!0,path:"/posts",component:oe}),Object(s.jsx)(W.a,{exact:!0,path:"/posts/:id",component:me}),t?Object(s.jsx)(Oe,{}):Object(s.jsx)(ge,{})]})]})})),ke=function(){return Object(a.useEffect)((function(){localStorage.token&&(u.a.defaults.headers.common["x-auth-token"]=localStorage.token,E.dispatch(M()))}),[]),Object(s.jsx)(l.a,{store:E,children:Object(s.jsxs)(U.a,{children:[Object(s.jsx)(B,{}),Object(s.jsxs)(W.c,{children:[Object(s.jsx)(W.a,{exact:!0,path:"/",component:V}),Object(s.jsx)(W.a,{exact:!0,path:"/*",component:Ne})]})]})})};i.a.render(Object(s.jsx)(c.a.StrictMode,{children:Object(s.jsx)(ke,{})}),document.getElementById("root"))}},[[71,1,2]]]);
//# sourceMappingURL=main.a57e0801.chunk.js.map