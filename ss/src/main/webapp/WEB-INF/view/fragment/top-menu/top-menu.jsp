<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList,
				qyn.javaweb.ss.note.model.*,
				qyn.javaweb.ss.note.dto.*
				 "%>
<html>
<head>
<style><%@include file="./top-menu-styles.css"%></style>
<head>
</head>
<body>
	<div id="b-menutop" class="d-flex justify-content-end align-items-center w-100 h-100">
		<%
				List<PriorityDTO> lPriorityDTO = (ArrayList<PriorityDTO>) request.getAttribute("list-all-priority");
				List<NoteTypeDTO> lNoteTypeDTO = (ArrayList<NoteTypeDTO>) request.getAttribute("list-all-note-type");
				List<NoteDTO> lNoteDTO = (ArrayList<NoteDTO>) request.getAttribute("list-all-note");	
		%>
		<%!
			public String getColorFromPriorityId(List<PriorityDTO> lPriorityDTO, int priorityId) {		
				for (int i = 0; i < lPriorityDTO.size(); i++) {
					if (lPriorityDTO.get(i).getPriorityId() == priorityId)
						return lPriorityDTO.get(i).getPriorityColor();
				}
				return "#000";
			}
			public String createColorStyleForPriortity(String color) {
				String colorStyle = "style=\"display:inline-block; width:30px; height:30px; background-color:"+ color + ";\"";
				return colorStyle;
			}
		%>
		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary" data-bs-toggle="modal"
			data-bs-target="#note">
			<i class="bi bi-sticky"></i>
		</button>
		<!-- Modal -->
		<div class="modal fade" id="note" data-bs-backdrop="static"
			data-bs-keyboard="false" tabindex="-1"
			aria-labelledby="staticBackdropLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg modal-dialog-centered modal-dialog-scrollable">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="staticBackdropLabel">
							Notes
						</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<div id="b-note-menu">
							<ul class="nav nav-tabs">								
								<li class="nav-item"><button id="btn-add-note" class="nav-link active" onclick="showAddNotePanel()">Note</button></li>
								<li class="nav-item"><button id="btn-manage-note" class="nav-link" onclick="showManageNotePanel()">Manage</button></li>															
							</ul>
						</div>
						<div id="b-add-note" class="mt-4">
							<div class="d-flex">
								<div class="mb-3 w-50 pe-1">
									<label for="exampleFormControlTextarea1" class="form-label">Type</label> 
									<select id="note-select-notetype"
										class="form-select form-select-sm"
										aria-label=".form-select-sm example">
										<%
										for (int i = 0; i < lNoteTypeDTO.size(); i++) {									
											out.print("<option value=\"" + lNoteTypeDTO.get(i).getNoteTypeId() + "\">" + lNoteTypeDTO.get(i).getNoteTypeType() + "</option>");
										}
										%>
									</select>
								</div>
								<div class="mb-3 w-50 ps-1">
									<label for="exampleFormControlTextarea1" class="form-label">Priority</label>
									<select id="note-select-priority"
										class="form-select form-select-sm"
										aria-label=".form-select-sm example">
										<%
													for (int i = 0; i < lPriorityDTO.size(); i++) {
														PriorityDTO priDTO = lPriorityDTO.get(i);
														out.print("<option value=\"" + priDTO.getPriorityId() +"\">" + priDTO.getPriorityLevel() + "</option>");
													}
												%>
									</select>
								</div>
							</div>

							<div class="mb-3">
								<label for="exampleFormControlTextarea1" class="form-label">Content</label>
								<textarea class="form-control" id="note-add-content" rows="3"></textarea>
							</div>
							<div class="mb-3">
								<label for="exampleFormControlTextarea1" class="form-label">Comment</label>
								<textarea class="form-control" id="note-add-comment" rows="3"
									placeholder="Don't have the comment yet!"></textarea>
							</div>
							<div class="mt-3">
								<button type="button" class="btn btn-primary"
									onclick="addNote()">Add</button>
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">Close</button>
								
							</div>
						</div>
						<div id="b-manage-note" class="d-none mt-4">
							<div id="b-manage-note-filter">
								<div id="b-mn-filter-type"></div>
								<div id="b-mn-filter-priority"></div>
								<div id="b-mn-filter-keyword"></div>
								<div id="b-mn-filter-comment"></div>
							</div>
							<table class="table">
								<thead>
									<tr>
										<th scope="col">#</th>
										<th scope="col">Note</th>
										<th scope="col">Time</th>
									</tr>
								</thead>
								<tbody>
									<%
									for (int i = 0; i < lNoteDTO.size(); i++) {
										NoteDTO noteDTO = lNoteDTO.get(i);
										out.print("<tr scope=\"row\">");
										out.print("<th><span " + createColorStyleForPriortity(noteDTO.getNotePriority().getPriorityColor())
										+ "></span></th>" + "<th> " + noteDTO.getNoteContent() + "</th>" + "<th> " + noteDTO.getNoteTimeAdded()
										+ "</th>" + "<th><span class=\"trash-hover mx-1\" onclick=\"deleteNote(" + noteDTO.getNoteId()
										+ ")\"><i class=\"bi bi-trash\"></i></span>" + "<span class=\"pen-hover mx-1\" onclick=\"editNote("
										+ noteDTO.getNoteId() + ")\"><i class=\"bi bi-pencil-fill\"></i><span>" + "</th>");
										out.print("</tr>");
									}
									%>
								</tbody>
							</table>
						
						</div>
					</div>
					<div class="modal-footer"></div>
				</div>
			</div>
		</div>
		<button class="btn btn-primary mx-1">
			<i class="bi bi-person-circle"></i>
		</button>
	</div>
	<script><%@include file="./top-menu-scripts.js"%></script>
</body>
</html>