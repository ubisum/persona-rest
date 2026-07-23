{{/*
Expand the name of the chart.
*/}}
{{- define "persona-rest.name" -}}
{{- .Chart.Name -}}
{{- end }}

{{/*
Create a fully qualified application name.
*/}}
{{- define "persona-rest.fullname" -}}
{{- printf "%s" .Release.Name -}}
{{- end }}

{{/*
Common labels.
*/}}
{{- define "persona-rest.labels" -}}
app.kubernetes.io/name: {{ include "persona-rest.name" . }}
app.kubernetes.io/instance: {{ .Release.Name }}
app.kubernetes.io/version: {{ .Chart.AppVersion }}
app.kubernetes.io/managed-by: {{ .Release.Service }}
helm.sh/chart: {{ .Chart.Name }}-{{ .Chart.Version }}
{{- end }}

{{/*
Selector labels.
*/}}
{{- define "persona-rest.selectorLabels" -}}
app.kubernetes.io/name: {{ include "persona-rest.name" . }}
app.kubernetes.io/instance: {{ .Release.Name }}
{{- end }}

{{/*
Create JDBC connection URL.
*/}}
{{- define "persona-rest.jdbcUrl" -}}
jdbc:mysql://{{ .Values.database.host }}:{{ .Values.database.port }}/{{ .Values.database.name }}
{{- end }}
